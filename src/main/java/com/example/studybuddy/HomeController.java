package com.example.studybuddy;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private Button mindmapsButton;

    @FXML private Button flashcardsButton;

    @FXML private AnchorPane rootPane;

    public Scene mindmapsScene;
    public Stage window;

    public Group rootMap = new Group();
    public Group cards = new Group();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void loadingScene() throws IOException {
        // Load the FXML file
        Parent loadingParent = FXMLLoader.load(getClass().getResource("loadingScene.fxml"));
        Scene loadingScene = new Scene(loadingParent);

        // Get the Stage information
        Stage loadingStage = new Stage();

        // Set the opacity of the root pane to 0
        loadingParent.setOpacity(0);

        // Create a fade-in effect for 5 seconds
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), loadingParent);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        // Show the scene on the stage
        loadingStage.setScene(loadingScene);
        loadingStage.show();

        // Hide the loading scene after the fade-in effect is finished
        fadeTransition.setOnFinished(event -> loadingStage.hide());
    }

    public void switchToMindmaps(ActionEvent event){
        try {
            Parent mindmapsParent = FXMLLoader.load(getClass().getResource("mindmapsScene.fxml"));
            mindmapsScene = new Scene(mindmapsParent);

            // Get the Stage information
            window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(mindmapsScene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToFlashcards(ActionEvent event){
        try {
            Parent mindmapsParent = FXMLLoader.load(getClass().getResource("flashcardsScene.fxml"));
            mindmapsScene = new Scene(mindmapsParent);

            // Get the Stage information
            window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(mindmapsScene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}