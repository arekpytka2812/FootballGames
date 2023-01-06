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

    public static boolean changePassword(String newPassword){

        if(!LoggedAdmin.isLoggedIn())
            return false;

        Connection connection = null;

        String conLogin = AdminMain.loggedAdmin.getConLogin();
        String oldConPass = AdminMain.loggedAdmin.getConPass();

        try {
            connection = DataBaseConnector.connect(conLogin, oldConPass);

            var statement = connection.createStatement();

            statement.executeUpdate("ALTER USER '" + conLogin + "'@'%' IDENTIFIED BY '" + newPassword + "'");

            DataBaseConnector.disconnect(connection);

            LoggedAdmin.removeInstance();

            AdminMain.loggedAdmin = LoggedAdmin.getInstance(conLogin, newPassword);

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;

    }



}