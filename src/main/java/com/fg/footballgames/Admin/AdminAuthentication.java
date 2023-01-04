package com.fg.footballgames.Admin;

import com.fg.footballgames.AppComponents.DataBaseConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminAuthentication {

    public static Connection processLogin(String login, String password){

        Connection connection = null;

        try{
            connection = DataBaseConnector.connect(login, password);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

}