package com.fg.footballgames.User.Controllers;


import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.AppComponents.PasswordChecker;
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

import java.sql.Connection;

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

        try{
            Connection con = DataBaseConnector.connect("user", "");
            var st = con.createStatement();
            ObservableList<String> listInstance = FXCollections.observableArrayList();
            var res = st.executeQuery("SELECT * FROM clubs_view");
            while(res.next())
                listInstance.add(res.getString(1));
            clubChooser.setItems(listInstance);
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void loginButtonPressed(ActionEvent event){

        if(loginField.getText().isEmpty())
            errorLabel.setText("Login cannot be empty!");
        else
            errorLabel.setText("");

        if(!UserAuthentication.processLogin(loginField.getText(), passwordField.getText())){
            errorLabel.setText("Wrong login or password!");
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

    @FXML
    private void chooseButtonPressed(ActionEvent event){

        if(!clubChooser.getValue().equals("null")){
            UserAuthentication.updateClub(clubChooser.getValue());
        }

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(UserMain.class, "UserMainPage.fxml"), UserMain.WINDOW_WIDTH, UserMain.WINDOW_HEIGHT));
        stage.show();
    }

}
