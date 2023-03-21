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
    private static Image r1=new Image("C:\\Users\\Tom Charnley\\rect10.png");
    public static ImageView r = new ImageView(r1);
    public Button B = new Button();
    private String text;
    public TextField t;

    public Node(double xi, double yi, String s){
        x=xi; y=yi; text=s; r.setX(x-r.getFitWidth()); r.setY(y-r.getFitHeight()); //t.setText(s);
    }
    public Node (){
    }
    public String toString(){
        return (x+" "+y+" "+l.getStartX()+" "+l.getStartY()+" "+l.getEndX()+" "+l.getEndY()+" "+bac+" "+text+"\n");
    }
}
