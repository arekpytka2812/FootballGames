package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Fixtures_view;
import com.fg.footballgames.DAOs.Views.Ref_count;
import com.fg.footballgames.DAOs.Views.Referees_view;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserRefereesCenterController {
    @FXML
    TableView refereesViewTableView;
    @FXML
    TableView amountMatchesTableView;
    private ObservableList<Referees_view> refereeList;
    private ObservableList<Ref_count> countList;

    @FXML
    private void initialize(){
        refereeList = DaoViewManager.selectAll(Referees_view.class);

        refereesViewTableView.setItems(refereeList);
        refereesViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Referees_view.class));
        countList = DaoViewManager.selectAll(Ref_count.class);
        amountMatchesTableView.setItems(countList);
        amountMatchesTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Ref_count.class));
    }
}
