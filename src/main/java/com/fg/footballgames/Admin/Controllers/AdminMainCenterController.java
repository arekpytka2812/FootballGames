package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.DaoManager;
import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.ResultSetWrapper;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.IDaoModel;
import com.fg.footballgames.DAOs.Tables.Personal_data;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.sql.Connection;

public class AdminMainCenterController {

    @FXML
    TableView queryView;

    @FXML
    Button insertButton;

    @FXML
    Button updateButton;

    ObservableList<? extends IDaoModel> modelsList;

    @FXML
    private void initialize(){

        queryView.setEditable(true);

        try{
            Connection con = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

            var st = con.createStatement();

            var res = st.executeQuery("SELECT * FROM personal_data");

            var modelsList = ResultSetWrapper.resultSetToObservableList(res, Personal_data.class);

            queryView.setItems(modelsList);
            queryView.getColumns().addAll(TableViewWrapper.listToTableColumnsList(modelsList, Personal_data.class));

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void insertButtonPressed(ActionEvent event){

        queryView.getColumns().clear();

        DaoManager.insert(new Personal_data("90", "Thomas", "PIerdoel", "2000", "POL"));

        try{
            Connection con = DataBaseConnector.connect(AdminMain.loggedAdmin.getConLogin(), AdminMain.loggedAdmin.getConPass());

            var st = con.createStatement();

            var res = st.executeQuery("SELECT * FROM personal_data");

            var modelsList = ResultSetWrapper.resultSetToObservableList(res, Personal_data.class);

            queryView.setItems(modelsList);
            queryView.getColumns().addAll(TableViewWrapper.listToTableColumnsList(modelsList, Personal_data.class));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void updateButtonPressed(ActionEvent event){

    }
}

