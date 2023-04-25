package com.example.studybuddy;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerControllerTest {

    @Test
    public void setusColor() {
        PlayerController pc= new PlayerController();
        pc.setusColor(Color.WHITE);
        assertEquals(Color.WHITE,pc.getUScolor());
    }


    @Test
    public void getUScolor()
    {
        PlayerController pc= new PlayerController();
        assertEquals(Color.WHITE,pc.getUScolor());
    }

    @Test
    public void getFontS()
    {
        PlayerController pc = new PlayerController();
        assertEquals(15,pc.getFontS());
    }

    @Test
    public void setFontS() {
        PlayerController pc= new PlayerController();
        pc.setFontS(12);
        assertEquals(12,pc.getFontS());
    }

    @Test
    public void changeColor()
    {

        PlayerController pc = new PlayerController();
        pc.usColor=pc.UColor.getValue();
        assertEquals(pc.usColor,pc.UColor);
    }

    @Test
    public void fontC()
    {
        PlayerController pc = new PlayerController();
        pc.x = pc.FontS.getValue();
        assertEquals(pc.x,pc.FontS);


    }
}