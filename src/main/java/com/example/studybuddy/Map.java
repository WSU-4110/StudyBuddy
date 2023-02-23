package com.example.studybuddy;

public class Map{

    Node map[]=new Node[100];
    public int pos=0;
    public Map(){
        map[0]=new Node();
    }
    public Node getNode(int x){
        return map[x];
    }
}
