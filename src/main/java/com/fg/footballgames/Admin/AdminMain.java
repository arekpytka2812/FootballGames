package com.fg.footballgames.Admin;

import com.fg.footballgames.AppComponents.AuthAccounts.LoggedAdmin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminMain extends Application {

    public final static int WINDOW_HEIGHT = 720;
    public final static int WINDOW_WIDTH = 1280;

    public static LoggedAdmin loggedAdmin = null;

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

        System.out.println("test");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
