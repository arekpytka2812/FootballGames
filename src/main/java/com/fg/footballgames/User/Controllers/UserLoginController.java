package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.AppComponents.PasswordChecker;
import com.fg.footballgames.User.UserAuthentication;

import com.fg.footballgames.User.UserMain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;


public class UserLoginController {

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    @FXML
    Button registerButton;

    @FXML
    Label errorLabel;

    private Stage stage;

    @FXML
    private void initialize() {

    }


    @FXML
    private void loginButtonPressed(ActionEvent event){

        if(!UserAuthentication.processLogin(loginField.getText(), passwordField.getText())){
            errorLabel.setText("Wrong login or password or no such user has been registered!");
            return;
        }

        errorLabel.setText("");

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(UserMain.class, "UserMainPage.fxml"), UserMain.WINDOW_WIDTH, UserMain.WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    private void registerButtonPressed(ActionEvent event){

        if(!PasswordChecker.isValid(passwordField.getText())) {
            errorLabel.setText("Password not match requirements!");
            return;
        }

        if(!UserAuthentication.processRegister(loginField.getText(), passwordField.getText())){
            errorLabel.setText("Login is already taken!");
            return;
        }

        UserAuthentication.processLogin(loginField.getText(), passwordField.getText());

        errorLabel.setText("");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(UserMain.class, "UserRegisterPage.fxml"), UserMain.WINDOW_WIDTH, UserMain.WINDOW_HEIGHT));
        stage.show();



    }

}
