package com.example.studybuddy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
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

    public Scene mindmapsScene;
    public Stage window;

    public Group rootMap = new Group();
    public Group cards = new Group();
    public Map map1;
    Group root= new Group();

    private Scene mapf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    public void createMap(ActionEvent event){
        map1= new Map();
        mapf = new Scene(root,1000,1000);
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        root.getChildren().add(map1.map[0].r);
        window.setScene(mapf);
        window.show();

        mapf.setOnMouseClicked(e-> mouse(e));
        //System.out.println("new node object assigned to nodeTest");
    }

    private void mouse(MouseEvent e){
        if (e.getButton()==MouseButton.PRIMARY) {
            System.out.println("a");
            boolean a=false;
            for(int i =0; i<map1.i; i++){
                if(Math.sqrt((Math.pow(e.getX()-map1.map[i].x, 2))+(Math.pow( e.getY()-map1.map[i].y,2)))<=100){
                    System.out.println("a1");
                    map1.s=i;
                    System.out.println(map1.s);
                    a=true;
                    break;
                }
            }
            if (a==false) addNode(e);
        }
        else if (e.getButton()==MouseButton.SECONDARY) {
            System.out.println("b");
            for(int i =0; i<map1.i; i++){
                if(Math.sqrt((Math.pow(e.getX()-map1.map[i].x, 2))+(Math.pow( e.getY()-map1.map[i].y,2)))<=100){
                    System.out.println("b2");
                    map1.map[map1.s].bac=i;
                    addLine();
                    break;
                }
            }
        }
    }

    public void addNode(MouseEvent e){
        map1.addNode(e.getX(),e.getY(), "enter text here");
        draw();
    }

    public void addLine(){

    }

    protected void draw(){
        rootMap= new Group();
       // for(int i =0; i<map1.i; i++) {
         //   root.getChildren().add(map1.map[i].l); }
        for(int i =0; i<map1.i; i++) {
            //root.getChildren().add(map1.map[i].l);
            root.getChildren().add(map1.map[i].r);}
        window.show();
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