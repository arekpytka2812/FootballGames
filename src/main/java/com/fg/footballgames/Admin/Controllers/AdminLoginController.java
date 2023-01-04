package com.fg.footballgames.Admin.Controllers;

import com.fg.footballgames.Admin.AdminMain;
import com.fg.footballgames.AppComponents.ParentLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminLoginController {

    @FXML
    Button loginButton;

    Stage stage;

    public void loginButtonAction(ActionEvent event){

        // TODO login process

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        var scene = new Scene(ParentLoader.loadParent(AdminMain.class, "testPage.fxml"));
        stage.setScene(scene);
        stage.show();
    }

}
