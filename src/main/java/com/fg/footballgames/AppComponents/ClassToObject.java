package com.fg.footballgames.AppComponents;

import com.fg.footballgames.DAOs.IDaoTableModel;

import java.lang.reflect.Field;

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
}
