package com.example.studybuddy;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck;
    @BeforeEach
    void setUp() {
        deck = new Deck("Test Deck");
    }
    @Test
     void isEmpty() {
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
    void cardsSize() {
        assertEquals(0, deck.cardsSize(), "Deck should have 0 cards at start");
        Card card=new Card("Question 1", "Answer 1", Color.BLUE);
        deck.addCard(card);
        assertEquals(1, deck.cardsSize(), "Deck should have 1 card after adding a card");

        deck.removeCard(card);
        assertEquals(0, deck.cardsSize(), "Deck should have 0 cards after removing the only card");

    }

    @Test
    void containsCard() {
        Card card1 = new Card("Question 1", "Answer 1", Color.BLUE);
        Card card2 = new Card("Question 2", "Answer 2", Color.RED);
        deck.addCard(card1);

        assertTrue(deck.containsCard(card1), "Deck should contain card1");
        assertFalse(deck.containsCard(card2), "Deck should not contain card2");
    }

    @Test
    void getTitleOfDeck() {
        assertEquals("Test Deck", deck.getTitleOfDeck(), "Deck should have title 'Test Deck'");
    }

    @Test
    void setTitle() {
        deck.setTitle("New Title");
        assertEquals("New Title", deck.getTitleOfDeck(), "Deck should have new title 'New Title'");

    }

    @Test
    void testToString() {
        Card card1 = new Card("Question 1", "Answer 1", Color.BLUE);
        Card card2 = new Card("Question 2", "Answer 2", Color.RED);
        deck.addCard(card1);
        deck.addCard(card2);

        String expected = "Deck [title=Test Deck, cards=[" + card1.toString() + ", " + card2.toString() + "]]";
        assertEquals(expected, deck.toString(), "Deck should have correct string representation");

    }
}