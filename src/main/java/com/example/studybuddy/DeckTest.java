package com.example.studybuddy;

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;
    @Before
    public void setUp() {
        deck = new Deck("Test Deck");
    }
    @Test
    public void isEmpty() {
        Deck deck = new Deck("MyDeck");
        assertTrue(deck.isEmpty());
        Card card = new Card("Question", "Answer", Color.BLUE);
        deck.addCard(card);
        assertFalse(deck.isEmpty());
        assertTrue(deck.containsCard(card));
        deck.removeCard(card);
        assertTrue(deck.isEmpty());
    }


    @Test
    public void cardsSize() {
        Deck deck = new Deck("MyDeck");
        assertTrue(deck.isEmpty());
        Card card = new Card("Question", "Answer", Color.BLUE);
        deck.addCard(card);
        assertTrue(deck.cardsSize()==1);

    }

    @Test
    public void containsCard() {
        Card card1 = new Card("Question 1", "Answer 1", Color.BLUE);
        Card card2 = new Card("Question 2", "Answer 2", Color.RED);
        deck.addCard(card1);

        assertTrue("Deck should contain card1", deck.containsCard(card1));
        assertFalse("Deck should not contain card2", deck.containsCard(card2));
    }

    @Test
    public void getTitleOfDeck() {
        assertEquals("Test Deck", deck.getTitleOfDeck(), "Test Deck");
    }

    @Test
    public void setTitle() {
        deck.setTitle("Test Deck");
        assertEquals("Test Deck", deck.getTitleOfDeck(), "Test Deck");

    }

    @Test
    public void testToString() {
        Card card1 = new Card("Question 1", "Answer 1", Color.BLUE);
        Card card2 = new Card("Question 2", "Answer 2", Color.RED);
        deck.addCard(card1);
        deck.addCard(card2);

        String expected = "Deck should have correct string representation";
        assertEquals(expected, deck.toString(), "Deck [title=Test Deck, cards=[Card{question='Question 1', answer='Answer 1'}, Card{question='Question 2', answer='Answer 2'}]]");

    }
}