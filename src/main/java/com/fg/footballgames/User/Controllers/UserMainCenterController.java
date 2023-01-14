package com.fg.footballgames.User.Controllers;

import com.fg.footballgames.AppComponents.*;
import com.fg.footballgames.DAOs.DaoViewEnum;
import com.fg.footballgames.DAOs.IDaoViewModel;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import com.fg.footballgames.DAOs.Views.Players_view;
import com.fg.footballgames.DAOs.Views.Stats_view;
import com.fg.footballgames.User.UserMain;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.Connection;

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

//        Connection connection;
//        try{
//            connection = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());
//
//            var st = connection.createStatement();
//            String query = SelectQueryBuilder.buildQueryLimit("clubs_view", 5);
//            var res = st.executeQuery(query);
//
//            scorersList = ResultSetWrapper.resultSetToObservableList(res, Clubs_view.class);
//
//            DataBaseConnector.disconnect(connection);
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        topScorersTable.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(scorersList, Clubs_view.class));
//        topScorersTable.setItems(scorersList);


//        scorersList = DaoViewManager.selectAll(Stats_view.class);
//        topScorersTable.setItems(scorersList);
//        topScorersTable.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(scorersList, Stats_view.class));

        clubsList = DaoViewManager.selectAll(classType.getClassName());

        topClubsTable.setItems(clubsList);
        topClubsTable.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(classType.getClassName()));



    }
}
