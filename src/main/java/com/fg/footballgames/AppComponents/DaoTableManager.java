package com.fg.footballgames.AppComponents;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.DAOs.IDaoTableModel;
import com.fg.footballgames.DAOs.Tables.Accounts;
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

    public static boolean insert(IDaoTableModel model){

        var clazz = model.getClass();
        var className = classNameToString(clazz);
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
            var res = st.executeUpdate(InsertQueryBuilder.buildQuery(className, columns, data));

            DataBaseConnector.disconnect(connection);

            return true;

        }catch (SQLException e) {
            return false;
        }

    }

    public static boolean insertUserAccount(Accounts userAccount){

        try{
            connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

            var st = connection.createStatement();

            var passwordResultSet =  st.executeQuery("select sha2('" + userAccount.getPassword() + "',256)");
            passwordResultSet.next();

            var hashedPassword = passwordResultSet.getString(1);

            if(userAccount.getFav_club().equals("NULL")){
                st.executeUpdate("INSERT INTO accounts VALUES('" + userAccount.getID() + "', '" + hashedPassword + "', " + userAccount.getFav_club() + ")");
            }
            else{
                st.executeUpdate("INSERT INTO accounts VALUES('" + userAccount.getID() + "', '" + hashedPassword + "', '" + userAccount.getFav_club() + "')");
            }

            DataBaseConnector.disconnect(connection);

            return true;

        }catch(SQLException e){
            e.printStackTrace();
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

    public static boolean delete(IDaoTableModel model){

        var clazz = model.getClass();
        var className = classNameToString(clazz);

        var fields = clazz.getDeclaredFields();

        var nameID = fields[0].getName();
        var ID = model.getID();

        try{
            connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

            var st = connection.createStatement();

            var res = st.executeUpdate("DELETE FROM " + className + " where " + nameID + " = '" + ID + "'");

            DataBaseConnector.disconnect(connection);

            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean update(IDaoTableModel model, String column, String newValue) {

        var clazz = model.getClass();
        var className = classNameToString(clazz);

        var fields = clazz.getDeclaredFields();

        var nameID = fields[0].getName();
        var ID = model.getID();

        try {
            connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

            var st = connection.createStatement();

            var res = st.executeUpdate("UPDATE " + className + " SET " + column + " = '" + newValue
                    + "' WHERE " + nameID + " = '" + ID + "'");

            DataBaseConnector.disconnect(connection);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

        public static boolean updateAccount(Accounts userAccount, String column, String newValue) {

            var ID = userAccount.getID();

            var className = classNameToString(Accounts.class);

            try {
                connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

                var st = connection.createStatement();


                if(newValue.equals("NULL")){
                    st.executeUpdate("UPDATE " + className + " SET " + column + " = " + newValue
                            + " WHERE login = '" + ID + "'");
                }
                else{
                    st.executeUpdate("UPDATE " + className + " SET " + column + " = '" + newValue
                            + "' WHERE login = '" + ID + "'");
                }

                DataBaseConnector.disconnect(connection);

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    private static <T> String classNameToString(Class<T> clazz){

        var className = clazz.getName();
        String[] subs = className.split("\\.");

        return subs[subs.length - 1].toLowerCase();
    }

}
