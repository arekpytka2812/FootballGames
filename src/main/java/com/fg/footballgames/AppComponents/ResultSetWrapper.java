package com.fg.footballgames.AppComponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

public class ResultSetWrapper {

    public static <T> ObservableList<T> getResults(ResultSet result, Class<T> classType) throws Exception {
        
        Class<T> clazz = classType;
        
        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());

        for(Field field : fields){
            field.setAccessible(true);
        }

        ObservableList<T> list = FXCollections.observableArrayList();

        while(result.next()){

             T dataTransferObject = clazz.getConstructor().newInstance();

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
