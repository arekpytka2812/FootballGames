package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Stadiums_view;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserStadiumsCenterController {
    @FXML
    TableView stadiumsViewTableView;

    private ObservableList<Stadiums_view> stadiumsList;

    @FXML
    private void initialize(){
        stadiumsList = DaoViewManager.selectAll(Stadiums_view.class);

        stadiumsViewTableView.setItems(stadiumsList);
        stadiumsViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Stadiums_view.class));

    }
}
