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
    public static String s= "file:./src/main/resources/rect10.png";
    public static Image r=new Image(s);
    public Button B = new Button();
    public String text;

    public Node(double xi, double yi, String s){
        x=xi; y=yi; text=s; //r.setX(x-r.getFitWidth()); r.setY(y-r.getFitHeight()); t.setText(s);
    }
    public Node (){
    }

    public static String setImage(String a){
        String q="file:./src/main/resources/"+a+".png";
        s=q;
        //r= new Image(q);
        return s;
    }

    public String toString(){
        return (x+" "+y+" "+l.getStartX()+" "+l.getStartY()+" "+l.getEndX()+" "+l.getEndY()+" "+bac+" "+text+"\n");
    }
}
