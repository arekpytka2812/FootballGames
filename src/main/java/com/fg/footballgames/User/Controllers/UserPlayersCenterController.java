package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.DAOs.DaoViewEnum;
import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UserPlayersCenterController {

    @FXML
    RadioButton allClubsRadio;
    @FXML
    RadioButton chosenClubRadio;
    @FXML
    ChoiceBox chosenClubChoiceBox;
    @FXML
    TableView playersTableView;
    private DaoViewEnum classType;
    private ObservableList<String> clubsList = FXCollections.observableArrayList();
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
    }

    @FXML
    private void allClubsRadioClicked(ActionEvent event){
        chosenClubChoiceBox.setDisable(true);
    }
}
