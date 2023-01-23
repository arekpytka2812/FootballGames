package com.fg.footballgames.User.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UserAboutPageController {

    @FXML
    Label InfoLabel;
    @FXML
    Hyperlink repositoryHyperlink;

    @FXML
    Hyperlink britneyHyperlink;

    @FXML
    Hyperlink madonesHyperLink;

    private static final String WORDS =
                    "Program aplikacji bazodanowej, \n" +
                    "która obsługuje rozgrywki piłkarskie, program kliencki.\n" +
                    "Aplikacja pozwala klientom na przeglądanie statystyk zawodników, \n" +
                    "kadr zespołów, pozycji w tabeli, śledzenia ulubionego zespołu";

    @FXML
    private void initialize(){
        InfoLabel.setText(WORDS);
    }

    @FXML
    private void repositoryLinkPressed(ActionEvent event){
        openHyperLink("https://github.com/arekpytka2812/FootballGames");
    }

    @FXML
    private void britneyLinkPressed(ActionEvent event){
        openHyperLink("https://github.com/arekpytka2812/");

    }

    @FXML
    private void madonesLinkPressed(ActionEvent event){
        openHyperLink("https://github.com/mradamones/");
    }

    private void openHyperLink(String uriLink){

        try {

            URI uri = new URI(uriLink);

            if (!Desktop.isDesktopSupported()) {
                return;
            }

            Desktop.getDesktop().browse(uri);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
