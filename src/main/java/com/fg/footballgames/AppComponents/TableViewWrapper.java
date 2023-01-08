package com.fg.footballgames.AppComponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

public class TableViewWrapper {

    public static <T> List<TableColumn<T ,String>> listToTableColumnsList(ObservableList<T> list, Class<T> classType){

        Field[] fields = classType.getDeclaredFields();
        List<TableColumn<T, String>> tableColumnList = FXCollections.observableArrayList();

        for(Field field : fields){

            field.setAccessible(true);

            tableColumnList.add(new TableColumn<>(field.getName()));

            tableColumnList.get(tableColumnList.size() - 1).setCellValueFactory((
                    new PropertyValueFactory<T, String>(field.getName())
            ));
        }

        return tableColumnList;
    }
}
