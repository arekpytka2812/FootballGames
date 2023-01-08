package com.fg.footballgames.AppComponents;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.DAOs.IDaoModel;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoManager {

    private static Connection connection = null;

    public static <T extends IDaoModel> boolean insert(IDaoModel model){

            try{
                var clazz = model.getClass();
                Field[] fields = clazz.getDeclaredFields();

                List<String> columns = new ArrayList<>();
                List<String> data = new ArrayList<>();

                for(var field : fields){
                    field.setAccessible(true);
                    columns.add(field.getName());
                }

                data.addAll(Arrays.asList(model.getAll()));

                var clazzName = clazz.getName();

                String[] subs = clazzName.split("\\.");

                connection = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());
                var st = connection.createStatement();
                var res = st.executeUpdate(InsertQueryBuilder.buildQuery(subs[subs.length - 1].toLowerCase(), columns, data));

                DataBaseConnector.disconnect(connection);

                return true;

            }catch (SQLException e) {
                return false;
            }
        }
}
