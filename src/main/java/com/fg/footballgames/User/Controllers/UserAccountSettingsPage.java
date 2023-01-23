package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.*;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import com.fg.footballgames.User.UserAuthentication;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    Label errorLabel;

    ObservableList<String> clubList = FXCollections.observableArrayList();

    @FXML
    private void initialize(){

        var clubListFromDataBase = DaoViewManager.selectAll(Clubs_view.class);

        clubList.add("No Favourite Club");

        for(Clubs_view club : clubListFromDataBase){
            clubList.add(club.getId_club());
        }

        favClubChooser.setItems(clubList);
        favClubChooser.setPromptText(UserMain.loggedUser.getFavClub());

    }

    @FXML
    private void savePasswordButtonPressed(ActionEvent event){
        if(!PasswordChecker.isValid(firstNewPasswordField.getText())){
            errorLabel.setText("Password does not meet requirements (min. 8 chars., one big and one small letter and one number)!");
            return;
        }

        if(oldPasswordField.getText().equals(firstNewPasswordField.getText())){
            errorLabel.setText("New password does not differ from the old one!");
            return;
        }

        if(!firstNewPasswordField.getText().equals(secondNewPasswordField.getText())){
           errorLabel.setText("New passwords differ from each other!");
           return;
        }

        if(!UserAuthentication.updatePassword(oldPasswordField.getText(), firstNewPasswordField.getText())){
            errorLabel.setText("Typed old password is different than the original one!");
            return;
        }

        oldPasswordField.clear();
        firstNewPasswordField.clear();
        secondNewPasswordField.clear();
        errorLabel.setText("");
    }

    @FXML
    private void saveClubButtonPressed(ActionEvent event){
        String chosenClub = favClubChooser.getValue();

        if(chosenClub.equals("No Favourite Club")){
            UserAuthentication.updateClub("NULL");
            return;
        }

        UserAuthentication.updateClub(chosenClub);
    }
}
