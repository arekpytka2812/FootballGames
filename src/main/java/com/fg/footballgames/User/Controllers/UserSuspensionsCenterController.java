package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Referees_view;
import com.fg.footballgames.DAOs.Views.Suspensions_count;
import com.fg.footballgames.DAOs.Views.Suspensions_view;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserSuspensionsCenterController {
    @FXML
    TableView suspensionsViewTableView;
    @FXML
    TableView suspensionCountTableView;

    private ObservableList<Suspensions_view> suspensionsList;
    private ObservableList<Suspensions_count> countList;

    @FXML
    private void initialize(){
        suspensionsList = DaoViewManager.selectAll(Suspensions_view.class);

        suspensionCountTableView.setItems(suspensionsList);
        suspensionsViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Suspensions_view.class));
        countList = DaoViewManager.selectAll(Suspensions_count.class);
        suspensionCountTableView.setItems(countList);
        suspensionCountTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Suspensions_count.class));
    }
}
