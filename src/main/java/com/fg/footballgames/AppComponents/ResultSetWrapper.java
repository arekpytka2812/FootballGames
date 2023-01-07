package com.fg.footballgames.AppComponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class ResultSetWrapper {

    public static <T> ObservableList<T> resultSetToObservableList(ResultSet result, Class<T> classType) throws Exception {

        Field[] fields = classType.getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);
        }

        ObservableList<T> list = FXCollections.observableArrayList();

        while(result.next()){

             T dataTransferObject = classType.getConstructor().newInstance();

             for(Field field : fields){

                 String name = field.getName();

                 String value = result.getString(name);

                 if(value == null)
                     continue;

                 field.set(dataTransferObject, field.getType().getConstructor(field.getType()).newInstance(value));
             }

             list.add(dataTransferObject);
        }

        return list;
    }
}
