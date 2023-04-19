package com.example.studybuddy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController {
    @FXML private Button mindmapsButton;

    @FXML private Button flashcardsButton;

    @FXML private AnchorPane rootPane;
    Parent parent;
    Scene scene;

    public void switchScene(ActionEvent event, String fxmlFilename) {
        try {
            Parent mindmapsParent = FXMLLoader.load(getClass().getResource(fxmlFilename));
            Scene mindmapsScene = new Scene(mindmapsParent);
            // Get the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(mindmapsScene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void switchToMindmaps(ActionEvent event){
        switchScene(event, "mindmapsScene.fxml");
    }
    public void switchToFlashcards(ActionEvent event){
        switchScene(event, "flashcardsScene.fxml");
    }
    public void returnHome(ActionEvent event){
        switchScene(event, "homepage.fxml");
    }
}