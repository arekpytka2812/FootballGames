package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.Admin.AdminAuthentication;
import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.ParentLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AdminMainPageController {


    @FXML
    BorderPane mainPane;

    @FXML
    Button aboutButton;

    @FXML
    Button accountSettingsButton;

    @FXML
    Button logoutButton;

    @FXML
    Button mainPageButton;

    private Stage stage;

    @FXML
    private void initialize(){
        mainPane.setCenter(ParentLoader.loadParent(AdminMain.class, "AdminMainCenter.fxml"));
    }

    @FXML
    private void aboutButtonPressed(ActionEvent event){

    }

    @FXML
    private void accountSettingsButtonPressed(ActionEvent event){
        AdminAuthentication.changePassword("Nowe1234");
    }

    @FXML
    private void logoutButtonPressed(ActionEvent event){

        AdminAuthentication.processLogout();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(AdminMain.class, "AdminLoginPage.fxml"), AdminMain.WINDOW_WIDTH, AdminMain.WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    private void mainPageButtonPressed(ActionEvent event){
        mainPane.setCenter(ParentLoader.loadParent(AdminMain.class, "AdminMainCenter.fxml"));
    }

}
