package com.fg.footballgames.User.Controllers;
import com.fg.footballgames.AppComponents.DaoViewManager;
import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.TableViewWrapper;
import com.fg.footballgames.DAOs.Views.Clubs_view;
import com.fg.footballgames.User.UserMain;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.SQLException;

public class UserClubsCenterController {
    @FXML
    TableView clubsViewTableView;
    @FXML
    Label checkMessageLabel;

    private ObservableList<Clubs_view> clubsList;

    @FXML
    private void initialize(){
        clubsList = DaoViewManager.selectAll(Clubs_view.class);

        clubsViewTableView.setItems(clubsList);
        clubsViewTableView.getColumns().addAll(TableViewWrapper.viewListToTableColumnsList(Clubs_view.class));
    }
    @FXML
    private void StadiumsViewTableViewOnFocus(MouseEvent event) throws SQLException {
        Connection con = DataBaseConnector.connect(UserMain.loggedUser.getConLogin(), UserMain.loggedUser.getConPass());
        var st = con.createStatement();
        final ObservableList<TablePosition> selectedCells = clubsViewTableView.getSelectionModel().getSelectedCells();
        var row = selectedCells.get(0).getRow();
        var id = clubsList.get(row).getId_club();
        var res = st.executeQuery("SELECT pitch_size('" + id + "')");
        res.next();
        String decision = res.getString(1);
        checkMessageLabel.setText(decision);
    }
}
