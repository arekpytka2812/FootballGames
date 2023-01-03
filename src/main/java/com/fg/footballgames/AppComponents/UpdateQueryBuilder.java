package com.fg.footballgames.AppComponents;

public class UpdateQueryBuilder {

    public static String buildUpdateQuery(String column, String table, String newVal, String statement){
        return "update " + table + " set " + column + " = '" + newVal + "' where " + statement + ";";
    }

}
