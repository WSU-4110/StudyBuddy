package com.example.studybuddy;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Node {
    public double x,y;
    public int bac;
    public Line l;
    public static Image r=new Image("file:./src/main/resources/rect10.png");
    public Button B = new Button();
    public TextField a;
    public String text;

    public Node(double xi, double yi, String s){
        x=xi; y=yi; text=s; //r.setX(x-r.getFitWidth()); r.setY(y-r.getFitHeight()); t.setText(s);
    }
    public Node (){
    }
    public void setText(){
        a = new TextField(text);
        a.setLayoutX(x);
        a.setLayoutY(y);
    }
    public String toString(){
        return (x+" "+y+" "+l.getStartX()+" "+l.getStartY()+" "+l.getEndX()+" "+l.getEndY()+" "+bac+" "+text+"\n");
    }
}
