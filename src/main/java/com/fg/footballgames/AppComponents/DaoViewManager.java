package com.fg.footballgames.AppComponents;

import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Views.Players_view;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;

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

    public static <T extends IDaoViewModel> ObservableList<T> selectQuery(String query, Class<T> clazz){

        ObservableList<T> modelsList = FXCollections.observableArrayList();

        try{
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var st = connection.createStatement();

            var res = st.executeQuery(query);

            modelsList = ResultSetWrapper.resultSetToObservableList(res, clazz);

            DataBaseConnector.disconnect(connection);

        }catch (Exception e) {

        }

        return modelsList;
    }

    public static <T extends IDaoViewModel> ObservableList<T> getPlayersFromClub(String clubName, Class<T> clazz){

        ObservableList<T> modelsList = FXCollections.observableArrayList();

        try{
            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());

            var st = connection.createStatement();

            String query = "SELECT * FROM players_view where CLUB=(select CLUB_NAME from clubs_view where id_club='" + clubName + "')";

            var res = st.executeQuery(query);

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
