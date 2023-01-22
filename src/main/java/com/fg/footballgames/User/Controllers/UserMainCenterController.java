package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.*;
import com.fg.footballgames.DAOs.DaoViewEnum;
import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserMainCenterController {

    @FXML
    TableView topClubsTable;

    @FXML
    TableView topScorersTable;

    private ObservableList<IDaoViewModel> scorersList;
    private ObservableList<IDaoViewModel> clubsList;

    private DaoViewEnum classType;

    @FXML
    private void initialize(){

        classType = DaoViewEnum.valueOf("Clubs_view");

        topClubsTable.getColumns().clear();
        topScorersTable.getColumns().clear();

        clubsList = DaoViewManager.selectAll(classType.getClassName());

        topClubsTable.setItems(clubsList);
        topClubsTable.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(classType.getClassName()));

        classType = DaoViewEnum.valueOf("Stats_view");

        scorersList=DaoViewManager.selectAll(classType.getClassName());

        topScorersTable.setItems(scorersList);
        topScorersTable.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(classType.getClassName()));
    }

}
