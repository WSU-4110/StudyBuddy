package com.example.studybuddy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private Button mindmapsButton;

    @FXML private Button flashcardsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void switchToMindmaps(){
        try {
            Parent sub= FXMLLoader.load(getClass().getResource("mindmapsScene.fxml"));
            AnchorPane pane=(AnchorPane)mindmapsButton.getScene().getRoot();
            pane.getChildren().add(sub);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void switchToFlashcards(){
        try {
            Parent sub= FXMLLoader.load(getClass().getResource("flashcardsScene.fxml"));
            AnchorPane pane=(AnchorPane)flashcardsButton.getScene().getRoot();
            pane.getChildren().add(sub);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}