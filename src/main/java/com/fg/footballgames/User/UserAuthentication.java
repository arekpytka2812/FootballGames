package com.fg.footballgames.User;

import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.QueryExecutor;
import com.fg.footballgames.DAOs.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.lang.Character;

public class UserAuthentication {

    public static Account processLogin(String login, String password){

        Account user = null;
        Connection connection = null;

        try{
            connection = DataBaseConnector.connect("non_logged_user", "");

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

    private static Account createUser(ResultSet authResult) throws SQLException{
        return new Account(authResult.getString("login"), authResult.getString("password"), authResult.getString("fav_club"));
    }



}
