package com.fg.footballgames.AppComponents;

import java.util.List;

public class InsertQueryBuilder {

    public static String buildQuery(String table, List<String> columns, List<String> data){
        StringBuilder sb = new StringBuilder("INSERT INTO " + table + "(");

        sb.append(columns.get(0));
        columns.remove(0);

        while(!columns.isEmpty()){
            sb.append(", " + columns.get(0));
            columns.remove(0);
        }

        sb.append(") VALUES(");

        sb.append("'" + data.get(0) + "'");
        data.remove(0);

        while(!data.isEmpty()){
            sb.append(", " + "'" + data.get(0) + "'");
            data.remove(0);
        }

        sb.append(");");

        return sb.toString();
    }
}
