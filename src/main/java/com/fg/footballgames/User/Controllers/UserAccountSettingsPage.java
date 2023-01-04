package com.fg.footballgames.User.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class UserAccountSettingsPage {

    @FXML
    PasswordField oldPasswordField;

    @FXML
    PasswordField firstNewPasswordField;

    @FXML
    PasswordField secondNewPasswordField;

    @FXML
    Button savePasswordButton;

    @FXML
    ComboBox<String> favClubChooser = new ComboBox<>();

    @FXML
    Button saveClubButton;

    @FXML
    private void initialize(){
        // TODO query on club list and pass it into clubList

        ObservableList<String> clubList = FXCollections.observableArrayList(
                "NULL",
                "GKŁ"
        );

        favClubChooser.setItems(clubList);
    }

    @FXML
    private void savePasswordButtonPressed(ActionEvent event){
        // TODO query to check if old password is valid

        if(firstNewPasswordField.getText() != null &&
                firstNewPasswordField.getText().equals(secondNewPasswordField.getText())){
            // TODO update query on user

        }

        oldPasswordField.clear();
        firstNewPasswordField.clear();
        secondNewPasswordField.clear();
    }

    @FXML
    private void saveClubButtonPressed(ActionEvent event){
        String chosenClub = favClubChooser.getValue();

        // TODO update query on user club
    }
}
