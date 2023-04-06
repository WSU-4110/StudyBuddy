package com.example.studybuddy;

import java.io.Serializable;
import javafx.scene.paint.Color;
public class Card implements Serializable {
    private String question;
    private String answer;
    private SerializableColor color;

    public Card() {
        this(null, null, null);
    }

    public Card(String question, String answer, Color color) {
        this.question = question;
        this.answer = answer;
        this.color = new SerializableColor(color);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Color getColor() {
        return color.getFXColor();
    }

    public void setColor(Color color) {
        this.color = new SerializableColor(color);
    }

    @Override
    public String toString() {
        return "Card{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
