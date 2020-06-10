package com.npcmaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MakerMain extends Application {

    Stage window;
    Scene scene1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        GridPane gridPane1 = null;
        try {
            gridPane1 = FXMLLoader.load(getClass().getResource("/EntryFullFXML.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        scene1 = new Scene(gridPane1);
        window.setScene(scene1);
        window.setResizable(false);
        window.show();
    }
}
