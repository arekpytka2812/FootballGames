package com.fg.footballgames.User;

import com.fg.footballgames.AppComponents.AuthAccounts.LoggedUser;
import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.SelectQueryBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAuthentication {

    public static boolean processLogin(String login, String password){

        if(LoggedUser.isLoggedIn())
            return false;

        Connection connection = null;

        try {
            connection = DataBaseConnector.connect("non_logged_user", "");

            var statement = connection.createStatement();
            var authResult = authenticate(statement, login, password);

            if (!assertUser(authResult)) {
                DataBaseConnector.disconnect(connection);
                return false;
            }

            UserMain.loggedUser = LoggedUser.getInstance(authResult.getString("login"));
            UserMain.loggedUser.setFavClub(authResult.getString("fav_club"));

            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            return false;
        }

        return true;
    }



    private static ResultSet authenticate(Statement statement, String login, String password) throws SQLException{

        String query = SelectQueryBuilder.buildPasswordCheckQuery("*", "accounts", login, password);

        return statement.executeQuery(query);
    }



    private static boolean assertUser(ResultSet resultSet) throws SQLException{
        return resultSet.next();
    }


    public static void processLogout() {
        LoggedUser.removeInstance();
    }



    public static boolean processRegister(String username, String password){

        if(LoggedUser.isLoggedIn())
            return false;

        Connection connection = null;

        try {
            connection = DataBaseConnector.connect("non_logged_user", "");

            var statement = connection.createStatement();
            var authResult = authenticate(statement, username, password);

            if (assertUser(authResult)) {
                DataBaseConnector.disconnect(connection);
                return false;
            }

            var temp = registerNewUser(statement, username, password);

            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            return false;
        }

        return true;
    }



    private static int registerNewUser(Statement statement, String username, String password) throws SQLException{
        return statement.executeUpdate("INSERT INTO accounts VALUES('" + username + "', SHA2('" + password + "', 256), NULL)");
    }


    public static boolean updateClub(String newFavClub){

        if(!LoggedUser.isLoggedIn())
            return false;

        Connection connection = null;

        try {
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var statement = connection.createStatement();

            if(newFavClub.equals("NULL")){
                statement.executeUpdate("UPDATE accounts SET fav_club = " + newFavClub + " WHERE login = '" + UserMain.loggedUser.getUsername() + "'");
            }
            else{
                statement.executeUpdate("UPDATE accounts SET fav_club = '" + newFavClub + "' WHERE login = '" + UserMain.loggedUser.getUsername() + "'");
            }
            UserMain.loggedUser.setFavClub(newFavClub);
            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }



    public static boolean updatePassword(String oldPassword, String newPassword){

        if(!LoggedUser.isLoggedIn())
            return false;

        if(!checkOldPassword(oldPassword)){
            return false;
        }

        Connection connection = null;

        try {
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var statement = connection.createStatement();
            statement.executeUpdate("UPDATE accounts SET password = SHA2('" + newPassword + "',256) WHERE login = '" + UserMain.loggedUser.getUsername() + "'");

            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            return false;
        }

        return true;
    }

    public static boolean checkOldPassword(String oldPassword){

        Connection connection = null;

        try {
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var statement = connection.createStatement();
            var authResult = statement.executeQuery("SELECT * from accounts WHERE login = '" + UserMain.loggedUser.getUsername() + "'");

            if (!authResult.next()) {
                return false;
            }

            var old_pass = authResult.getString("password");

            var passResult = statement.executeQuery("select sha2('" + oldPassword + "',256)");

            passResult.next();
            var comp_pass = passResult.getString(1);

            DataBaseConnector.disconnect(connection);

            return comp_pass.equals(old_pass);

        }catch(SQLException e){
            return false;
        }
    }
}
