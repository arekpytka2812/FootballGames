package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.Admin.AdminAuthentication;
import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.User.UserMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLoginController {

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    @FXML
    Label errorLabel;

    private Stage stage;

    @FXML
    private void initialize(){
        loginField.clear();
        passwordField.clear();
        errorLabel.setText("");
    }

    @FXML
    private void loginButtonAction(ActionEvent event){

        if(!AdminAuthentication.processLogin(loginField.getText(), passwordField.getText())){
            errorLabel.setText("Wrong login or password!");
            return;
        }

        errorLabel.setText("");

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(AdminMain.class, "AdminMainPage.fxml"), UserMain.WINDOW_WIDTH, UserMain.WINDOW_HEIGHT));
        stage.show();
    }

}
