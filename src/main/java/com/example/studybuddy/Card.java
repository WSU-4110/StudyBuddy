package com.example.studybuddy;

import java.io.Serializable;
public class Card implements Serializable {
    private static Card single_instance=null;

    private String question;
    private String answer;

    public Card() {
        this(null, null);
    }

    public static Card card()
    {
        if(single_instance==null){
            single_instance=new Card();
        }
        return single_instance;
    }
    public Card(String question, String answer) {
        this.question = question;
        this.answer = answer;
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

    @Override
    public String toString() {
        return "Card{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
