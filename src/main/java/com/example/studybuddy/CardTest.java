package com.example.studybuddy;

import com.example.studybuddy.Card;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
class CardTest {
    Card card;
    @Before
    void setUp() {
        card = new Card("Question","Answer", Color.RED, Color.BLACK);
    }

    @Test
    void testGetQuestion() {
        String actual = card.getQuestion();
        String expected = "Question";
        assertEquals(expected, actual);
    }

    @Test
    void testSetQuestion() {
        card.setQuestion("SetQuestion");
        String actual = card.getQuestion();
        String expected = "SetQuestion";
        assertEquals(expected, actual);
    }

    @Test
    void testGetAnswer() {
        String actual = card.getAnswer();
        String expected = "Answer";
        assertEquals(expected, actual);
    }

    @Test
    void testSetAnswer() {
        card.setAnswer("SetAnswer");
        String actual = card.getAnswer();
        String expected = "SetAnswer";
        assertEquals(expected, actual);
    }

    @Test
    void testGetColor() {
        Color actual = card.getColor();
        Color expected = Color.RED;
        assertEquals(expected, actual);
    }

    @Test
    void testSetColor() {
        card.setColor(Color.BLUE);
        Color actual = card.getColor();
        Color expected = Color.BLUE;
        assertEquals(expected, actual);
    }

    @Test
    void testGetTextColor() {
        Color actual = card.getTextColor();
        Color expected = Color.BLACK;
        assertEquals(expected, actual);
    }

    @Test
    void testSetTextColor() {
        card.setColor(Color.GREEN);
        Color actual = card.getColor();
        Color expected = Color.GREEN;
        assertEquals(expected, actual);
    }
}