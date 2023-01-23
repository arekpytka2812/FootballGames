package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import com.fg.footballgames.User.UserAuthentication;
import com.fg.footballgames.User.UserMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;



public class UserRegisterChooseClubController {

    @FXML
    ComboBox<String> clubChooser = new ComboBox<>();

    @FXML
    Button chooseClubButton;

    ObservableList<String> clubList = FXCollections.observableArrayList();

    private Stage stage;

    @FXML
    private void initialize(){

        clubList.clear();

        var clubListFromDataBase = DaoViewManager.selectAll(Clubs_view.class);

        clubList.add("No Favourite Club");

        for(Clubs_view club : clubListFromDataBase){
            clubList.add(club.getId_club());
        }

        clubChooser.setItems(clubList);
    }

    @FXML
    private void chooseButtonPressed(ActionEvent event){

        String chosenClub = clubChooser.getValue();

        if(chosenClub.equals("No Favourite Club")){
            UserAuthentication.updateClub("NULL");
        }
        else{
            UserAuthentication.updateClub(chosenClub);
        }


        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(UserMain.class, "UserMainPage.fxml"), UserMain.WINDOW_WIDTH, UserMain.WINDOW_HEIGHT));
    }

}
