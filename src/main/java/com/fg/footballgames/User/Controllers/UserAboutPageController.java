package com.fg.footballgames.User.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class UserAboutPageController {

    @FXML
    Label InfoLabel;
    @FXML
    Hyperlink repositoryHyperlink;

    @FXML
    Hyperlink readmeHyperlink;
    private static final String WORDS =
                    "Program aplikacji bazodanowej, \n" +
                    "która obsługuje rozgrywki piłkarskie, program kliencki.\n" +
                    "Aplikacja pozwala klientom na przeglądanie statystyk zawodników, \n" +
                    "kadr zespołów, pozycji w tabeli, śledzenia ulubionego zespołu";

    @FXML
    private void initialize(){
        InfoLabel.setText(WORDS);
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
