package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.Admin.AdminAuthentication;
import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.ParentLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// TODO create admin login page

public class AdminLoginController {

    @FXML
    Button loginButton;

    Stage stage;

    public void loginButtonAction(ActionEvent event){

        // TODO login process

        String temp1 = "debil", temp2 = "gruzarski";

        AdminAuthentication.processLogin(temp1, temp2);

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        // TODO add admin main page and change it here
        stage.setScene(new Scene(ParentLoader.loadParent(AdminMain.class, "testPage.fxml")));
        stage.show();
    }

}
