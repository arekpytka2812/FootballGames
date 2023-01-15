package com.fg.footballgames.AppComponents;

import com.fg.footballgames.DAOs.IDaoTableModel;
import com.fg.footballgames.DAOs.IDaoViewModel;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

public class TableViewWrapper {

    public static <T extends IDaoTableModel> List<TableColumn<T ,String>> tableListToTableColumnsList(Class<T> classType){

        Field[] fields = classType.getDeclaredFields();
        List<TableColumn<T, String>> tableColumnList = FXCollections.observableArrayList();

        for(Field field : fields){

            tableColumnList.add(new TableColumn<>(field.getName()));

            tableColumnList.get(tableColumnList.size() - 1).setCellValueFactory((
                    new PropertyValueFactory<>(field.getName())
            ));
        }

        return tableColumnList;
    }

    public static <T extends IDaoViewModel> List<TableColumn<T ,String>> viewListToTableColumnsList(Class<T> classType){

        Field[] fields = classType.getDeclaredFields();
        List<TableColumn<T, String>> tableColumnList = FXCollections.observableArrayList();

        for(Field field : fields){

            tableColumnList.add(new TableColumn<>(field.getName()));

            tableColumnList.get(tableColumnList.size() - 1).setCellValueFactory((
                    new PropertyValueFactory<>(field.getName())
            ));
        }

        return tableColumnList;
    }

}
