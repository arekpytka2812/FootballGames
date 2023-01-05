package com.fg.footballgames.Admin;

import com.fg.footballgames.AppComponents.AuthAccounts.LoggedAdmin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminMain extends Application {

    public final static int WINDOW_HEIGHT = 720;
    public final static int WINDOW_WIDTH = 1280;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminMainCenter.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Football Games Admin App");
        stage.setScene(scene);
        stage.show();

        stage.setMinWidth(1280);
        stage.setMinHeight(720);

        stage.setMaxHeight(1080);
        stage.setMaxWidth(1920);

//        Connection con = DataBaseConnector.connect("head_admin", "");
//
//        var st = con.createStatement();
//
//        var result = st.executeQuery("select * from referees_view;");

        var test = LoggedAdmin.getInstance("head_admin", "");
        System.out.println("test");

        //List<Referee> accounts = ResultSetWrapper.getResults(result, Referee.class);

//        for (var person : accounts){
//            System.out.println("Name: " + person.getId_referee() + ", surname: " + person.getPersonal_data_id() + ", date: " + person.getPermissions() );
//        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
