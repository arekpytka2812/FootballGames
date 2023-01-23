package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Canadian;
import com.fg.footballgames.DAOs.Views.Future_fixtures;
import com.fg.footballgames.DAOs.Views.Stadiums_view;
import com.fg.footballgames.DAOs.Views.Stats_view;
import com.fg.footballgames.User.UserMain;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class UserStatsCenterController {
    @FXML
    TableView statsViewTableView;
    @FXML
    TableView goalContributionTableView;

    private ObservableList<Stats_view> statsList;
    private ObservableList<Canadian> canadian;

    @FXML
    private void initialize(){
        statsList = DaoViewManager.selectAll(Stats_view.class);

        statsViewTableView.setItems(statsList);
        statsViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Stats_view.class));
        canadian = DaoViewManager.selectQuery("SELECT * FROM canadian", Canadian.class);

        goalContributionTableView.setItems(canadian);
        goalContributionTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Canadian.class));

    }
}
