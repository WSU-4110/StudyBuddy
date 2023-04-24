package com.example.studybuddy;

import java.io.Serializable;

public class Map implements Serializable {

    static Node map[]=new Node[100];

    public static int i=1, max=100, s=1, setmulti=2;

    public Map(){ }

    public static Node getNode(int x){
        return map[x];
    }

    public static Node addNode(double x, double y, String s){
        if(i>max){
            extend();
        }
        map[i]=new Node(x,y,s);
        i++;
        return map[i-1];
    }

    public static int extend()
    {
        Node map2[]=map;
        max*=setmulti;
        map=new Node[max];
        for(int a=0; a<map2.length;a++){
            map[a]=map2[a];
        }
        return max;
    }
    public static int changeMulti(int a){
        setmulti=a;
        return a;
    }

    public static int setMax(int a){
        max=a;
        return a;
    }

    public static int setSelect(int a){
        s=a;
        return a;

    }
    public static boolean undoNode(){
        if(i>0){
            i-=1;
            return true;
        }
        return false;
    }
    public static boolean save(){
        return true;
    }

    public static boolean load(){
        return true;
    }
}