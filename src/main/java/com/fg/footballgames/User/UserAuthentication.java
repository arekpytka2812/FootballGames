package com.fg.footballgames.User;

import com.fg.footballgames.AppComponents.QueryExecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.lang.Character;

public class UserAuthentication {

    public static UserAccount processLogin(Connection connection){

        String login = "debil", password = "gruzarski";

        UserAccount user = null;

        try{
            var statement = connection.createStatement();

            var authResult = authenticate(statement, login, password);

            if(!assertUser(authResult)){
                return user;
            }

            user = createUser(authResult);

        }catch(SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    private static ResultSet authenticate(Statement statement, String login, String password) throws SQLException{

        String query = QueryExecutor.buildPasswordCheckQuery("*", "accounts", login, password);

        return statement.executeQuery(query);

    }

    private static boolean assertUser(ResultSet resultSet) throws SQLException{
        return resultSet.next();
    }

    private static UserAccount createUser(ResultSet authResult) throws SQLException{
        return new UserAccount(authResult.getString("login"), authResult.getString("password"), authResult.getString("fav_club"));
    }


    public static boolean isValid(String value) {
        return containsLowerCase(value) &&
                containsUpperCase(value) &&
                containsNumber(value) && value.length() > 7;
    }

    private static boolean containsLowerCase(String value) {
        for(int i=0;i<value.length();i++){
            if(Character.isLowerCase(value.charAt(i)))
              return true;
        }
        return false;
    }

    private static boolean containsUpperCase(String value) {
        for(int i=0;i<value.length();i++){
            if(Character.isUpperCase(value.charAt(i)))
                return true;
        }
        return false;
    }

    private static boolean containsNumber(String value) {
        for(int i=0;i<value.length();i++){
            if(Character.isDigit(value.charAt(i)))
                return true;
        }
        return false;
    }
}
