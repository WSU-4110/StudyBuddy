package com.example.studybuddy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public Group cards = new Group();
    public Map map1 = new Map();

    public Group rootMap = new Group();

    Group root = new Group();
    FileChooser f = new FileChooser();
    private Scene mapf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void createMap(ActionEvent event) {
        mapf = new Scene(root, 1920, 1080);
        window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mapf);
        draw();
        mapf.setOnMouseClicked(e -> {
            mouse(e);
        });
    }

    private void mouse(MouseEvent e) {
        if (map1.i > 1) {
            for (int i = 1; i < map1.i; i++) {
                map1.map[i].text = map1.map[i].a.getText();
            }
        }
        if (e.getButton() == MouseButton.PRIMARY) {
            boolean a = false;
            for (int i = 1; i < map1.i; i++) {
                if (Math.sqrt((Math.pow(e.getX() - map1.map[i].x, 2)) + (Math.pow(e.getY() - map1.map[i].y, 2))) <= 200) {
                    map1.s = i;
                    System.out.println(map1.s);
                    a = true;
                }
            }
            if (a == false) addNode(e);
        } else if (e.getButton() == MouseButton.SECONDARY) {
            for (int i = 1; i < map1.i; i++) {
                if (Math.sqrt((Math.pow(e.getX() - map1.map[i].x, 2)) + (Math.pow(e.getY() - map1.map[i].y, 2))) <= 200) {
                    map1.map[map1.s].bac = i;
                    draw();
                }
            }
        }
    }

    public void addNode(MouseEvent e) {
        map1.addNode(e.getX(), e.getY(), "enter text here");
        map1.s = map1.i - 1;
        draw();
    }

    protected void draw() {
        root.getChildren().clear();
        Button b = new Button();
        Button b1 = new Button();
        Button b2 = new Button();
        Button b3 = new Button();
        b.setText("back");
        b1.setLayoutY(30);
        b1.setText("save");
        b2.setLayoutY(60);
        b2.setText("undo");
        b3.setLayoutY(90);
        b3.setText("load");
        EventHandler<ActionEvent> save = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                saveMaps();
            }
        };
        EventHandler<ActionEvent> goback = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                back();
            }
        };
        EventHandler<ActionEvent> undo = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                map1.undoNode();
                draw();
            }
        };
        EventHandler<ActionEvent> load = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                loadMap();
            }
        };
        b1.setOnAction(save);
        b.setOnAction(goback);
        b2.setOnAction(undo);
        b3.setOnAction(load);
        root.getChildren().addAll(b, b1, b2, b3);
        for (int i = 1; i < map1.i; i++) {
            if (map1.map[i].bac > map1.i) {
                map1.map[i].bac = 0;
            }
        }
        for (int i = 1; i < map1.i; i++) {
            if (map1.map[i].bac != 0) {
                root.getChildren().add(new Line(map1.map[i].x, map1.map[i].y, map1.map[map1.map[i].bac].x, map1.map[map1.map[i].bac].y));
            }
        }
        for (int i = 1; i < map1.i; i++) {
            ImageView r = new ImageView(map1.map[i].r);
            r.setX(map1.map[i].x - 200);
            r.setY(map1.map[i].y - 150);//-r.getFitWidth()-r.getFitHeight()
            r.setScaleX(.5);
            r.setScaleY(.5);
            root.getChildren().add(r);
            map1.map[i].setText();
            root.getChildren().add(map1.map[i].a);
        }
        window.show();
    }

        public void switchToHome (ActionEvent event){
            try {
                Parent mindmapsParent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
                mindmapsScene = new Scene(mindmapsParent);

                // Get the Stage information
                window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(mindmapsScene);
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void back () {
            try {
                map1 = new Map();
                Parent mindmapsParent = FXMLLoader.load(getClass().getResource("mindmapsScene.fxml"));
                mindmapsScene = new Scene(mindmapsParent);
                window.setScene(mindmapsScene);
                window.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void saveMaps () {
            try {
                ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(map1.map[1].text)));
                os.writeObject(map1);
            } catch (Exception e) {
                System.out.println("Error Serializing decks");
                e.printStackTrace();
            }
        }
        public void loadMap () {
            try {
                f.setInitialDirectory(new File("src/"));
                File a = f.showOpenDialog(new Stage());
                ObjectInputStream is = new ObjectInputStream(Files.newInputStream(Paths.get(a.getName())));
                map1 = (Map) is.readObject();
                draw();
            } catch (Exception e) {

                System.out.println("Error Deserializing decks");
                e.printStackTrace();    
            }
        }
    }