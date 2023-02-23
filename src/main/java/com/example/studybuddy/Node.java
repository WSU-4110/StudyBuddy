package com.example.studybuddy;

public class Node {
    private double x,y,sx,sy;
    public String shape;

    public Node(double xi, double yi,double sxi, double syi, String s){
        x=xi; y=yi; sx=sxi; sy=syi; shape=s;
    }
    public Node (){
        x=20; y=20; sx=10; sy=30; shape="Rectangle";
    }

    public double x(){
        return x;
    }
    public double y(){
        return y;
    }
    public double sx(){
        return sx;
    }
    public double sy(){
        return sx;
    }
}
