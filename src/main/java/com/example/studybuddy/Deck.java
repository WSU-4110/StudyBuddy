package com.example.studybuddy;

import java.util.ArrayList;

public class Deck {
    private String subject;
    private ArrayList<Flashcard> deck;

    public Deck() {
        this.subject = "No name";
        this.deck = new ArrayList<>();
    }

    public Deck(String subject, ArrayList<Flashcard> deck) {
        this.subject = subject;
        this.deck = deck;
    }

    public String getSubject() {
        return this.subject;
    }

    public ArrayList<Flashcard> getDeck() {
        return this.deck;
    }

    public void setSubject(String name) {
        this.subject = name;
    }

    public void addCard(Flashcard card) {
        this.deck.add(card);
    }

    public void removeCard(Flashcard card) {
        this.deck.remove(card);
    }
}
