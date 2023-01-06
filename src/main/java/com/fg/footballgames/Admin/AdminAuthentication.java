package com.fg.footballgames.Admin;

import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.AuthAccounts.LoggedAdmin;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminAuthentication {

    public static boolean processLogin(String login, String password){

        if(LoggedAdmin.isLoggedIn())
            return false;

        Connection connection = null;

        try{
            connection = DataBaseConnector.connect(login, password);

            DataBaseConnector.disconnect(connection);

            AdminMain.loggedAdmin = LoggedAdmin.getInstance(login, password);

        }catch(SQLException e){
            return false;
        }

        return true;
    }

    public static void processLogout(){
        LoggedAdmin.removeInstance();
    }

}