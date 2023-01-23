package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import com.fg.footballgames.DAOs.Views.Goals_difference;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserGoalDiffCenterController {
    @FXML
    TableView goalDiffTableView;

    private ObservableList<Goals_difference> goalDiffList;
    @FXML
    private void initialize(){
        goalDiffList = DaoViewManager.selectAll(Goals_difference.class);

        goalDiffTableView.setItems(goalDiffList);
        goalDiffTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Goals_difference.class));
    }
}
