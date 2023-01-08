package com.fg.footballgames.User;

import com.fg.footballgames.AppComponents.AuthAccounts.LoggedUser;
import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.QueryExecutor;

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

            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public static ResultSet authenticate(Statement statement, String login, String password) throws SQLException{

        String query = QueryExecutor.buildPasswordCheckQuery("*", "accounts", login, password);

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
            e.printStackTrace();
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

            statement.executeUpdate("UPDATE accounts SET fav_club = '" + newFavClub + "' WHERE login = '" + UserMain.loggedUser.getUsername() + "'");

            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }
    public static boolean updatePassword(String newPassword){
        if(!LoggedUser.isLoggedIn())
            return false;

        Connection connection = null;

        try {
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var statement = connection.createStatement();

            statement.executeUpdate("UPDATE accounts SET password = SHA2('" + newPassword + "',256) WHERE login = '" + UserMain.loggedUser.getUsername() + "'");

            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }
}
