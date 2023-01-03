package com.fg.footballgames.AppComponents;

import com.fg.footballgames.User.UserMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneLoader {

    public static Scene loadScene(Class className, String fileName){

        Parent root = null;

        try {
            root = FXMLLoader.load(className.getResource(fileName));
        }catch (IOException e){
            System.out.println("No nie tym razem");
        }

        Scene scene = new Scene(root);

        return scene;
    }

}
