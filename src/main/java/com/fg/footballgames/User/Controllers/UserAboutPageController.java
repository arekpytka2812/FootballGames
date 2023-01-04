package com.fg.footballgames.User.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class UserAboutPageController {

    @FXML
    Hyperlink repositoryHyperlink;

    @FXML
    Hyperlink readmeHyperlink;

    @FXML
    private void initialize(){

        repositoryHyperlink.setText("Repository");
        readmeHyperlink.setText("ReadMe");
    }

    @FXML
    private void repositoryLinkPressed(ActionEvent event){
        // TODO implement opening browser with repo link
    }

    @FXML
    private void readmeLinkPressed(ActionEvent event){
        // TODO implement opening browser with readme link
    }
}
