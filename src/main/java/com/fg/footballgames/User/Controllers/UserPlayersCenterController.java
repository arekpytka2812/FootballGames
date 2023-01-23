package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.*;
import com.fg.footballgames.DAOs.DaoViewEnum;
import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Tables.Players;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import com.fg.footballgames.DAOs.Views.Main_standings;
import com.fg.footballgames.DAOs.Views.Players_view;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;

public class UserPlayersCenterController {

    @FXML
    RadioButton allClubsRadio;

    @FXML
    RadioButton chosenClubRadio;

    @FXML
    ChoiceBox chosenClubChoiceBox;

    @FXML
    TableView playersTableView;

    DaoViewEnum classType = DaoViewEnum.valueOf("Players_view");
    private ObservableList<String> clubsList = FXCollections.observableArrayList();
    private ObservableList<IDaoViewModel> playersList;
    ToggleGroup group = new ToggleGroup();

    @FXML
    private void initialize(){

        allClubsRadio.setToggleGroup(group);
        chosenClubRadio.setToggleGroup(group);

        var clubsListFromDB = DaoViewManager.selectAll(Clubs_view.class);

        for(Clubs_view club : clubsListFromDB){
            clubsList.add(club.getId_club());
        }

        chosenClubChoiceBox.setItems(clubsList);

    }

    @FXML
    private void chosenClubRadioClicked(ActionEvent event){
        chosenClubChoiceBox.setDisable(false);
        playersTableView.getColumns().clear();


    }

    @FXML
    private void allClubsRadioClicked(ActionEvent event){

        chosenClubChoiceBox.setDisable(true);
        playersTableView.getColumns().clear();

        playersList = DaoViewManager.selectAll(classType.getClassName());

        playersTableView.setItems(playersList);
        playersTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Players_view.class));
    }

    @FXML
    private void chosenClubChoiceBoxSelected(ActionEvent event){

        var clubName = chosenClubChoiceBox.getValue().toString();
        playersTableView.getColumns().clear();

        playersList = DaoViewManager.getPlayersFromClub(clubName, classType.getClassName());

        playersTableView.setItems(playersList);
        playersTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Players_view.class));
    }
}
