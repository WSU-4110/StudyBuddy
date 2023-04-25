package com.example.studybuddy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    @Test
    public void changeMulti() { assertEquals(3, Map.changeMulti(3)); }
    @Test
    public void extend() { assertEquals(300, Map.extend()); }
    public void save(){ assertTrue( Map.save()); }

    @Test
    public void setMax(){ assertEquals(300, Map.setMax(300)); }

    @Test
    public void setSelect(){ assertEquals(10, Map.setSelect(10)); }

    @Test
    public void undoNode(){ assertEquals(true, Map.undoNode()); }
}