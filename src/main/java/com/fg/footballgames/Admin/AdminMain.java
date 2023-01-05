package com.fg.footballgames.Admin;

import com.fg.footballgames.AppComponents.DataBaseConnector;
import com.fg.footballgames.AppComponents.ResultSetWrapper;
import com.fg.footballgames.User.UserAccount;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.List;

public class AdminMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminMainCenter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        stage.setMinWidth(1280);
        stage.setMinHeight(720);

        stage.setMaxHeight(1080);
        stage.setMaxWidth(1920);

        Connection con = DataBaseConnector.connect("head_admin", "");

        var st = con.createStatement();

        var result = st.executeQuery("select * from accounts ORDER BY login DESC;");

        List<UserAccount> accounts = ResultSetWrapper.getResults(result, UserAccount.class);

        for (UserAccount user : accounts){
            System.out.println("Username: " + user.getLogin() + ", favClub: " + user.getFav_club());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
