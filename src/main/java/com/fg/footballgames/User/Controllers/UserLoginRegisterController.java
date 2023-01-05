package com.fg.footballgames.User.Controllers;


import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.User.UserAuthentication;

import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


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
    ComboBox<String> clubChooser = new ComboBox<>();

    @FXML
    Button chooseClubButton;

    @FXML
    Label errorLabel;

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
        if(loginField.getText().isEmpty())
            errorLabel.setText("Login cannot be empty!");
        else
            errorLabel.setText("");

        // TODO login process
        System.out.println("login");
    }

    public void registerButtonPressed(ActionEvent event){
        if(UserAuthentication.isValid(passwordField.getText())) {
            errorLabel.setText("");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(ParentLoader.loadParent(UserMain.class, "UserRegisterPage.fxml"), UserMain.WINDOW_HEIGHT, UserMain.WINDOW_WIDTH));
            stage.show();
        }
        else{
            errorLabel.setText("Password not match requirements!");
        }

    }

    @FXML
    protected void chooseButtonPressed(ActionEvent event){

        String chosenClub = clubChooser.getValue();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        var scene = new Scene(ParentLoader.loadParent(UserMain.class, "UserLoginPage.fxml"));
        stage.setScene(scene);
        stage.show();
    }

}
