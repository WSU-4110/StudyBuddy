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

public class MindMapController implements Initializable {
    @FXML
    private Button mindmapsButton;

    @FXML
    private Button flashcardsButton;

    @FXML
    private Button createmindmap;

    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void switchToMindmaps(ActionEvent event) {
        try {
            Parent mindmapsParent = FXMLLoader.load(getClass().getResource("mindmapsScene.fxml"));
            Scene mindmapsScene = new Scene(mindmapsParent);

            // Get the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(mindmapsScene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void switchToFlashcards(ActionEvent event) {
        try {
            Parent mindmapsParent = FXMLLoader.load(getClass().getResource("flashcardsScene.fxml"));
            Scene mindmapsScene = new Scene(mindmapsParent);

            // Get the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(mindmapsScene);
            window.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}