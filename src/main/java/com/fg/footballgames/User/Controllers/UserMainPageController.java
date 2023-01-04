package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.ParentLoader;
import com.fg.footballgames.User.UserMain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;


public class UserMainPageController {

    @FXML
    BorderPane mainPane;

    @FXML
    MenuButton viewPicker;

    @FXML
    Button accountSettingButton;

    @FXML
    Button aboutButton;

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
        viewPicker.setText(viewPicker.getItems().get(0).getText());

        mainPane.setCenter(ParentLoader.loadParent(UserMain.class, UserPageEnum.MainPage.getPath()));
    }

}
