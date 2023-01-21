package com.fg.footballgames.AppComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    //private static final String url = "jdbc:mysql://2a02:a317:e03d:8600:58c4:4c37:270c:4a7f:3306/footballgames";
    private static final String url = "jdbc:mysql://localhost:3306/footballgames";

    public static Connection connect(String userName, String password) throws SQLException{
        return DriverManager.getConnection(url, userName, password);
    }

    public static void disconnect(Connection connection) throws SQLException{
        connection.close();
    }
}