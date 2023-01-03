package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.SceneLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminLoginController {

    @FXML
    Button loginButton;

    Stage stage;

    public void loginButtonAction(ActionEvent event){

        // TODO login process

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(SceneLoader.loadScene(AdminMain.class, "testPage.fxml"));
        stage.show();
    }

}
