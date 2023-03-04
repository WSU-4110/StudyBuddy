package com.example.studybuddy;

public class Flashcard {

    private String frontText;
    private String backText;

    public Flashcard(String frontText, String backText) {
        this.frontText = frontText;
        this.backText = backText;
    }

    public String getFront() {
        return frontText;
    }

    public String getBack() {
        return backText;
    }

    public void setFront(String text) {
        this.frontText = text;
    }

    public void setBack(String text) {
        this.backText = text;
    }
}
