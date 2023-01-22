package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.DaoViewEnum;
import com.fg.footballgames.DAOs.IDaoViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserCoachesCenterController {
    // TODO - make tables with all coaches
    @FXML
    TableView coachesViewTableView;

    private ObservableList<IDaoViewModel> coachesList;

    @FXML
    private void initialize(){

        coachesViewTableView.getColumns().clear();

        coachesList = DaoViewManager.selectAll(DaoViewEnum.valueOf("Coaches_view").getClassName());

        coachesViewTableView.setItems(coachesList);
        coachesViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(DaoViewEnum.valueOf("Coaches_view").getClassName()));
    }
}
