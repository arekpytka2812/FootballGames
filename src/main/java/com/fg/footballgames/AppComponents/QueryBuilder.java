package com.fg.footballgames.AppComponents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// TODO klasa totalnie do przerobienia

public class QueryBuilder {

    private static final String selectFrom = "SELECT * FROM ?";
    private static final String selectWhere = "SELECT * FROM ? WHERE ?";
    private static final String updateWhere = "UPDATE ? SET ? WHERE ?";
    private static final String insertTable = "INSERT INTO ? (?) VALUES (?)";

    public static String buildMultiColumnsQuery(List<String> columns, String table){

        StringBuilder query = new StringBuilder("select ");

        query.append(columns.get(0));
        columns.remove(0);

        while(!columns.isEmpty()){
            query.append(", ");
            query.append(columns.get(0));

            columns.remove(0);
        }

        query.append(" from ");
        query.append(table);
        query.append(";");

        return query.toString();

    }

    public static String buildQuery(String column, String table){
        return "select " + column + " from " + table + ";";
    }

    public static String buildPasswordCheckQuery(String column, String table, String login, String pass){

        return "select " + column + " from " + table + " where login = '" + login + "' and password = SHA2('" + pass + "',256);";
    }

    public static ResultSet preparedQuery(Connection con, String table) throws SQLException {
        PreparedStatement query = con.prepareStatement(selectFrom);
        query.setString(1, table);

        System.out.println(query.toString());

        return query.executeQuery();
    }

    public static ResultSet preparedMultiColumnQuery (Connection con, List<String> columns, String table) throws SQLException {

        StringBuilder multi = new StringBuilder("");
        for(String column : columns){
            multi.append(column + ",");
        }
        multi.deleteCharAt(multi.length() - 1);

        PreparedStatement query = con.prepareStatement(selectFrom);

        query.setString(1, multi.toString());
        //query.setString(2, table);

        return query.executeQuery();
    }
}
