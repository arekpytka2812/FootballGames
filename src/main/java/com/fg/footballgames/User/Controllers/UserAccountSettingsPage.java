package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.*;
import com.fg.footballgames.AppComponents.AuthAccounts.LoggedAdmin;
import com.fg.footballgames.AppComponents.AuthAccounts.LoggedUser;
import com.fg.footballgames.DAOs.Tables.Personal_data;
import com.fg.footballgames.DAOs.Views.ClubView;
import com.fg.footballgames.User.UserAuthentication;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

import java.sql.Connection;
import java.sql.SQLException;

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
        try{
            Connection con = DataBaseConnector.connect("user", "");
            var st = con.createStatement();
            ObservableList<String> listInstance = FXCollections.observableArrayList();
            var res = st.executeQuery("SELECT * FROM clubs_view");
            while(res.next())
                listInstance.add(res.getString(1));
            favClubChooser.setItems(listInstance);
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void savePasswordButtonPressed(ActionEvent event){
        Connection connection = null;
        String old_pass = null;
        String comp_pass = null;
        try {
            connection = DataBaseConnector.connect("user", "");

            var statement = connection.createStatement();
            var authResult = UserAuthentication.authenticate(statement, UserMain.loggedUser.getUsername(), oldPasswordField.getText());

            old_pass = authResult.getString("password");

            var passResult = statement.executeQuery("select sha2('" + oldPasswordField.getText() + "',256)");

            comp_pass = passResult.getString(0);
            DataBaseConnector.disconnect(connection);

        }catch (SQLException e){
            e.printStackTrace();
        }
        if(PasswordChecker.isValid(firstNewPasswordField.getText()) && !oldPasswordField.getText().equals(firstNewPasswordField.getText()) &&
                firstNewPasswordField.getText().equals(secondNewPasswordField.getText()) && old_pass == comp_pass){

                UserAuthentication.updatePassword(firstNewPasswordField.getText());
        }


        oldPasswordField.clear();
        firstNewPasswordField.clear();
        secondNewPasswordField.clear();
    }

    @FXML
    private void saveClubButtonPressed(ActionEvent event){
        String chosenClub = favClubChooser.getValue();
        UserAuthentication.updateClub(chosenClub);
    }
}
