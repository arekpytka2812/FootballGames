package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.User.UserAuthentication;
import com.fg.footballgames.User.UserMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class UserMainPageController {

    @FXML
    BorderPane mainPane;

    @FXML
    MenuButton viewPicker;

    @FXML
    Button mainPageButton;

    @FXML
    Button logoutButton;

    @FXML
    Button accountSettingsButton;

    @FXML
    Button aboutButton;

    private Stage stage;

    @FXML
    private void initialize(){

        viewPicker.getItems().clear();

        UserPageEnum[] pagesList = UserPageEnum.values();
        List<MenuItem> menuItems = new ArrayList<>();

        for (UserPageEnum userPageEnum : pagesList) {

            var item = new MenuItem(userPageEnum.toString());

            item.setOnAction((e) -> {
                mainPane.setCenter(ParentLoader.loadParent(UserMain.class, userPageEnum.getPath()));
                viewPicker.setText(userPageEnum.toString());
            });

            menuItems.add(item);
        }

        viewPicker.getItems().addAll(menuItems);
        viewPicker.setText("---");

        mainPane.setCenter(ParentLoader.loadParent(UserMain.class, "UserMainCenter.fxml"));
    }

    @FXML
    private void mainPageButtonPressed(ActionEvent event){
        mainPane.setCenter(ParentLoader.loadParent(UserMain.class, "UserMainCenter.fxml"));
        viewPicker.setText("---");
    }

    @FXML
    private void logoutButtonPressed(ActionEvent event){

        UserAuthentication.processLogout();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ParentLoader.loadParent(UserMain.class, "UserLoginPage.fxml"), UserMain.WINDOW_WIDTH, UserMain.WINDOW_HEIGHT));
    }

    @FXML
    private void accountSettingsButtonPressed(ActionEvent event){
        mainPane.setCenter(ParentLoader.loadParent(UserMain.class, "UserAccountSettingsPage.fxml"));
        viewPicker.setText("---");
    }

    @FXML
    private void aboutButtonPressed(ActionEvent event){
        mainPane.setCenter(ParentLoader.loadParent(UserMain.class, "UserAboutPage.fxml"));
        viewPicker.setText("---");
    }
}
