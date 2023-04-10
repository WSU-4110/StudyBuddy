package com.example.studybuddy;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CardTest {

    @Test
    void testGetQuestion() {
        Card card = new Card("Question","Answer", Color.RED);
        assertEquals("Question",card.getQuestion());
    }

    @Test
    void testSetQuestion() {
        Card card = new Card("Question","Answer", Color.RED);
        card.setQuestion("SetQuestion");
        assertEquals("SetQuestion",card.getQuestion(),"Question set to \"SetQuestion\"");
    }

    @Test
    void testGetAnswer() {
        Card card = new Card("Question","Answer", Color.RED);
        assertEquals("Answer",card.getAnswer());
    }

    @Test
    void testSetAnswer() {
        Card card = new Card("Question","Answer", Color.RED);
        card.setAnswer("SetAnswer");
        assertEquals("SetAnswer",card.getAnswer(),"Answer set to \"SetAnswer\"");
    }

    @Test
    void testGetColor() {
        Card card = new Card("Question","Answer", Color.RED);
        assertEquals(Color.RED,card.getColor());
    }

    @Test
    void testSetColor() {
        Card card = new Card("Question","Answer", Color.RED);
        card.setColor(Color.BLUE);
        assertEquals(Color.BLUE,card.getColor(),"Color set to BLUE");
    }
}