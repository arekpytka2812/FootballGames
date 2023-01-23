package com.fg.footballgames.AppComponents;

import com.fg.footballgames.DAOs.IDaoTableModel;

import java.lang.reflect.Field;
import java.util.List;

public class ClassToObject {

    public static <T extends IDaoTableModel> IDaoTableModel createObject(Class<T> clazz, String ID)  {

        Field[] fields = clazz.getDeclaredFields();

        T returnObject = null;

        for(var field : fields){
            field.setAccessible(true);
        }

        try{
            returnObject = clazz.getConstructor().newInstance();

            fields[0].set(returnObject, fields[0].getType().getConstructor(String.class).newInstance(ID));

        }catch (Exception e){
            e.printStackTrace();
        }

        return returnObject;

    }

    public static <T extends IDaoTableModel> IDaoTableModel createObject(Class<T> clazz, List<String> values){

        Field[] fields = clazz.getDeclaredFields();

        T returnObject = null;

        for(var field : fields){
            field.setAccessible(true);
        }

        try{
            returnObject = clazz.getConstructor().newInstance();

            for(int i = 0; i < fields.length; ++i){
                fields[i].set(returnObject, fields[i].getType().getConstructor(String.class).newInstance(values.get(i)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return returnObject;
    }
}
