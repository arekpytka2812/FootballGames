package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserClubsCenterController {
    // TODO - make tables with all clubs
    @FXML
    TableView clubsViewTableView;
    private ObservableList<Clubs_view> clubsList;

    @FXML
    private void initialize(){
        clubsList = DaoViewManager.selectAll(Clubs_view.class);

        clubsViewTableView.setItems(clubsList);
        clubsViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Clubs_view.class));
    }
}
