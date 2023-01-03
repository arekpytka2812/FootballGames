package com.fg.footballgames.User;

import com.fg.footballgames.AppComponents.QueryExecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
