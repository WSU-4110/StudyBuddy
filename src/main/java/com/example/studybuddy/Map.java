package com.example.studybuddy;

public class Map{

    Node map[]=new Node[100];
    public int i=0, max=100, s=0;

    public Map(){
        map[0]=new Node(500,500, "begin");
    }
    public Node getNode(int x){
        return map[x];
    }

    public void addNode(double x, double y, String s){
        if(i>max){
            extendo();
        }
        i++;
        map[i]=new Node(x,y,s);
    }
    private void extendo()
    {
        max=max*2;
        Node map2[]=map;
        map=new Node[max];
        for(int a=0; a<max;a++){
            map[a]=map2[a];
        }
    }

    public Node getTop(){
        return map[i];
    }
    public void save(){

    }
}
