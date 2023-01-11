package com.fg.footballgames.AppComponents;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.DAOs.IDaoTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoTableManager {

    private static Connection connection = null;

    public static <T extends IDaoTableModel> boolean insert(IDaoTableModel model){

        var clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<String> columns = new ArrayList<>();
        List<String> data = new ArrayList<>();

        for(var field : fields){
            columns.add(field.getName());
        }

        try{
            data.addAll(Arrays.asList(model.getAll()));

            connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());
            var st = connection.createStatement();
            var res = st.executeUpdate(InsertQueryBuilder.buildQuery(classNameToString(clazz), columns, data));

            DataBaseConnector.disconnect(connection);

            return true;

        }catch (SQLException e) {
            return false;
        }

    }


    public static <T extends IDaoTableModel> ObservableList<T> selectAll(Class<T> clazz){

        ObservableList<T> modelsList = FXCollections.observableArrayList();

        var className = classNameToString(clazz);

        try{
            connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

            var st = connection.createStatement();

            var res = st.executeQuery("SELECT * FROM " + className);

            modelsList = ResultSetWrapper.resultSetToObservableList(res, clazz);

            DataBaseConnector.disconnect(connection);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return modelsList;
    }


    private static <T> String classNameToString(Class<T> clazz){

        var className = clazz.getName();
        String[] subs = className.split("\\.");

        return subs[subs.length - 1].toLowerCase();
    }

    // TODO update i delete dopisać

}
