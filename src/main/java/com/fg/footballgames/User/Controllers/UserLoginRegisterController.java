package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.SceneLoader;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class UserLoginRegisterController {

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    @FXML
    Button registerButton;

    @FXML
    ComboBox<String> clubChooser = new ComboBox<String>();

    @FXML
    Button chooseClubButton;

    private Stage stage;

    @FXML
    private void initialize() {

        ObservableList<String> clubList = FXCollections.observableArrayList(
                "NULL",
                "GKŁ"
        );

        clubChooser.setItems(clubList);
    }

    public void loginButtonPressed(ActionEvent event){
        System.out.println("login");
    }

    public void registerButtonPressed(ActionEvent event){

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(SceneLoader.loadScene(UserMain.class, "UserRegisterPage.fxml"));
        stage.show();

    }

    public void chooseButtonPressed(ActionEvent event){
        String chosenClub = clubChooser.getValue();


        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(SceneLoader.loadScene(UserMain.class, "UserLoginPage.fxml"));
        stage.show();
    }

}
