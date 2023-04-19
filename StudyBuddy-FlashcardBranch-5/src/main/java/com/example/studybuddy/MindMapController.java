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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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

    public static Map map1;
    Group root= new Group();

    private Scene mapf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public boolean createMap(ActionEvent event){
        try {
            map1 = new Map();
            mapf = new Scene(root, 1000, 1000);
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(mapf);

            mapf.setOnMouseClicked(e -> mouse(e));
            //System.out.println("new node object assigned to nodeTest")
        }
        catch(RuntimeException a){
            return false;
        }
        return true;
    }

    private boolean mouse(MouseEvent e){
        try {
            if (e.getButton() == MouseButton.PRIMARY) {
                boolean a = false;
                for (int i = 1; i < map1.i; i++) {
                    if (Math.sqrt((Math.pow(e.getX() - map1.map[i].x, 2)) + (Math.pow(e.getY() - map1.map[i].y, 2))) <= 200) {
                        map1.s = i;
                        a = true;
                        break;
                    }
                }
                if (a == false) addNode(e);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                for (int i = 1; i < map1.i; i++) {
                    if (Math.sqrt((Math.pow(e.getX() - map1.map[i].x, 2)) + (Math.pow(e.getY() - map1.map[i].y, 2))) <= 200) {
                        map1.map[map1.s].bac = i;
                        draw();
                        break;
                    }
                }
            }
        }
        catch(RuntimeException a){
            return false;
        }
        return true;
    }

    public boolean addNode(MouseEvent e){
        try {
            map1.addNode(e.getX(), e.getY(), "enter text here");
            map1.s = map1.i - 1;
            return draw();
        }
        catch(RuntimeException a){
            return false;
        }
    }

    protected boolean draw(){
        try {
            rootMap = new Group();
            // for(int i =0; i<map1.i; i++) {
            //   root.getChildren().add(map1.map[i].l); }
            for (int i = 1; i < map1.i; i++) {
                if (map1.map[i].bac != 0) {
                    root.getChildren().add(new Line(map1.map[i].x, map1.map[i].y, map1.map[map1.map[i].bac].x, map1.map[map1.map[i].bac].y));
                }
            }
            for (int i = 1; i < map1.i; i++) {
                ImageView r = new ImageView(map1.map[i].r);
                r.setX(map1.map[i].x - 200);
                r.setY(map1.map[i].y - 150);//-r.getFitWidth()-r.getFitHeight()
                root.getChildren().add(r);
                TextField a = new TextField(map1.map[i].text);
                a.setLayoutX(map1.map[i].x);
                a.setLayoutY(map1.map[i].y);
                root.getChildren().add(a);
            }
            window.show();
            return true;
        }
        catch(RuntimeException a){
            return false;
        }
    }

   public void switchToHome(ActionEvent event){
        try {
            Parent mindmapsParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
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