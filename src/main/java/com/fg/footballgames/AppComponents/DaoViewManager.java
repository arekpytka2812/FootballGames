package com.fg.footballgames.AppComponents;

import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;

public class DaoViewManager {

    private static Connection connection = null;

    public static <T extends IDaoViewModel> ObservableList<T> selectAll(Class<T> clazz){

        ObservableList<T> modelsList = FXCollections.observableArrayList();

        var className = classNameToString(clazz);

        try{
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var st = connection.createStatement();

            var res = st.executeQuery("SELECT * FROM " + className);

            modelsList = ResultSetWrapper.resultSetToObservableList(res, clazz);

            DataBaseConnector.disconnect(connection);

        }catch (Exception e) {

        }

        return modelsList;
    }


    private static <T> String classNameToString(Class<T> clazz){

        var className = clazz.getName();
        String[] subs = className.split("\\.");

        return subs[subs.length - 1].toLowerCase();
    }
}
