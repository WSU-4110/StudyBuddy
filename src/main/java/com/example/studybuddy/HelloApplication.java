package com.example.studybuddy;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            HomeController homeController=new HomeController();
            homeController.loadingScene();

            Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
        } catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        launch();
    }
}