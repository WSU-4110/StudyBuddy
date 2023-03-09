package com.example.studybuddy;

import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable {
    private String title;
    private ArrayList<Card> cards;

    public Deck(String title, ArrayList<Card> cards) {
        this.title = title;
        this.cards = cards;
    }

    public Deck(String title) {
        this.title = title;
        this.cards = new ArrayList<Card>();
    }

    public Deck() {
        this(null, null);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public int cardsSize() {
        return this.cards.size();
    }

    public boolean containsCard(Card card) {
        return this.cards.contains(card);
    }

    public String getTitleOfDeck() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Deck [title=" + title + ", cards=" + cards + "]";
    }
}