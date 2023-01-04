package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.SceneLoader;
import com.fg.footballgames.User.UserAuthentication;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    ComboBox<String> clubChooser = new ComboBox<String>();

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
        System.out.println("login");
    }

    public void registerButtonPressed(ActionEvent event){
        if(UserAuthentication.isValid(passwordField.getText())) {
            errorLabel.setText("");
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneLoader.loadScene(UserMain.class, "UserRegisterPage.fxml"));
            stage.show();
        }
        else{
            errorLabel.setText("Password not match requirements!");
        }
    }

    public void chooseButtonPressed(ActionEvent event){
        String chosenClub = clubChooser.getValue();


        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(SceneLoader.loadScene(UserMain.class, "UserLoginPage.fxml"));
        stage.show();
    }

}
