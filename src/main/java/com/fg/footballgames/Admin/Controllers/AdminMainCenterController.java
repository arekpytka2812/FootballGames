package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.AppComponents.DaoTableManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Tables.Personal_data;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class AdminMainCenterController {

    @FXML
    TableView queryView;

    @FXML
    Button insertButton;

    @FXML
    Button updateButton;

    ObservableList modelsList;

    @FXML
    private void initialize(){

        queryView.setEditable(true);

    }

    @FXML
    private void insertButtonPressed(ActionEvent event){

        queryView.getColumns().clear();

        DaoTableManager.insert(new Personal_data("96", "Thomas", "dsffdssdf", "2000", "POL"));

        modelsList = DaoTableManager.selectAll(Personal_data.class);

        queryView.setItems(modelsList);
        queryView.getColumns().addAll(TableViewWrapper.listToTableColumnsList(modelsList, Personal_data.class));

    }
    @FXML
    private void updateButtonPressed(ActionEvent event){

    }
}

