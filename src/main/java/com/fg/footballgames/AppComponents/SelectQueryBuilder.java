package com.fg.footballgames.AppComponents;

import java.util.List;

public class SelectQueryBuilder {

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

    public static String buildQueryEqualString(String table, String colReq, String condition){
        return "select * from " + table + " where " + colReq + " = '" + condition + "';";
    }

    public static String buildQueryEqualNumber(String table, String colReq, String condition){
        return "select * from " + table + " where " + colReq + " = " + condition + ";";
    }

    public static String buildQueryLimit(String table, int limit){
        return "select * from " + table + " limit " + limit + ";";
    }

    public static String buildQueryLower(String table, String colReq, String condition){
        return "select * from " + table + " where " + colReq + " < " + condition + ";";
    }

    public static String buildQueryHigher(String table, String colReq, String condition){
        return "select * from " + table + " where " + colReq + " > " + condition + ";";
    }

    public static String buildQueryLike(String table, String colReq, String condition){
        return "select * from " + table + " where " + colReq + " LIKE '" + condition + "';";
    }

    public static String buildQueryBetween(String table, String colReq, String condition1, String condition2){
        return "select * from " + table + " where " + colReq + " between " + condition1 + " AND " + condition2 + ";";
    }

    public static String buildQueryJoin(String table1, String table2, String column1, String column2){
        return "select * from " + table1 + " join " + table2 + " ON " + table1 + "." + column1 + "=" + table2 + "." +column2 + ";";
    }

    public static String buildPasswordCheckQuery(String column, String table, String login, String pass){

        return "select " + column + " from " + table + " where login = '" + login + "' and password = SHA2('" + pass + "',256);";
    }

}
