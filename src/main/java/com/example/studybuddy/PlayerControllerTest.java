package com.example.studybuddy;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerControllerTest {

    @Test
    public void setusColor() {
        PlayerController pc= new PlayerController();

    }


    @Test
    public void getUScolor()
    {
        PlayerController pc= new PlayerController();

    }

    @Test
    public void getFontS()
    {
        PlayerController pc = new PlayerController();

    }

    @Test
    public void setFontS() {
        PlayerController pc= new PlayerController();

    }

    @Test
    public void changeColor()
    {

        PlayerController pc = new PlayerController();

    }

    @Test
    public void fontC()
    {
        PlayerController pc = new PlayerController();
        pc.x = pc.FontS.getValue();
        assertEquals(pc.x,pc.FontS);


    }
}