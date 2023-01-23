package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Tables.Standings;
import com.fg.footballgames.DAOs.Views.Fixtures_view;
import com.fg.footballgames.DAOs.Views.Main_standings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserStandingsCenterController {

    @FXML
    TableView standingsViewTableView;
    private ObservableList<Main_standings> standingsList;
    @FXML
    private void initialize(){
        standingsList = DaoViewManager.selectAll(Main_standings.class);

        standingsViewTableView.setItems(standingsList);
        standingsViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Main_standings.class));

    }
}
