package com.fg.footballgames.AppComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {

    private static final String url = "jdbc:mysql://localhost:3306/footballgames";

    public static Connection connect(String userName, String password) throws SQLException{
        return DriverManager.getConnection(url, userName, password);
    }

    public static void disconnect(Connection connection) throws SQLException{
        connection.close();
    }
}