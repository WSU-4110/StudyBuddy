package com.example.homescreen;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)
    {

       


        Group root = new Group();
        Scene scene = new Scene(root, 250, 275, Color.BLUE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}