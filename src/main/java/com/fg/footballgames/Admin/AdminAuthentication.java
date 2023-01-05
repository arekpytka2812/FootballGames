package com.fg.footballgames.Admin;

import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.AuthAccounts.LoggedAdmin;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminAuthentication {

    public static boolean processLogin(String login, String password) throws SQLException{

        Connection connection = DataBaseConnector.connect(login, password);

        if(connection == null){
            DataBaseConnector.disconnect(connection);
            return false;
        }

        DataBaseConnector.disconnect(connection);

        var temp = LoggedAdmin.getInstance(login, password);

        return true;
    }

}