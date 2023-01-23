package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Fixtures_view;
import com.fg.footballgames.DAOs.Views.Future_fixtures;
import com.fg.footballgames.User.UserMain;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class UserFixturesCenterController {
    @FXML
    TableView fixturesViewTableView;
    @FXML
    TableView favClubFixturesTableView;
    private ObservableList<Fixtures_view> fixturesList;
    private ObservableList<Future_fixtures> futureList;

    @FXML
    private void initialize(){
        fixturesList = DaoViewManager.selectAll(Fixtures_view.class);

        fixturesViewTableView.setItems(fixturesList);
        fixturesViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Fixtures_view.class));
        futureList = DaoViewManager.selectQuery("SELECT * FROM future_fixtures WHERE (HOST='"+ UserMain.loggedUser.getFavClub() +"' OR GUEST='"+ UserMain.loggedUser.getFavClub() +"') LIMIT 5", Future_fixtures.class);
        favClubFixturesTableView.setItems(futureList);
        favClubFixturesTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Future_fixtures.class));

    }
}
