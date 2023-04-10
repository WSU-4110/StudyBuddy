package com.example.studybuddy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EditorController {
    private Stage stage;
    private Scene scene;
    private Deck deck;
    private String question;
    private String answer;
    private Color color;
    private Card selectedCard;
    private DataHandlingCard ds = DataHandlingCard.getInstance();

    @FXML
    TextArea questionTextArea;
    @FXML
    TextArea answerTextArea;
    @FXML
    Label mainLabel;
    @FXML
    ColorPicker UColor;

    public void backToDeck(ActionEvent event) {
    }

    public void switchToPlayer(ActionEvent event) {
        System.out.println("Switch to player");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("player.fxml"));
            Parent root = loader.load();
            PlayerController controller = loader.getController();
            controller.initPlayer(this.deck);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCard(ActionEvent event) {
        this.question = questionTextArea.getText();
        this.answer = answerTextArea.getText();
        this.color = UColor.getValue();

        if (this.selectedCard == null) {
            System.out.println("New card");
            Deck revisedDeck = this.deck;
            revisedDeck.addCard(new Card(this.question, this.answer, this.color));
            System.out.println("revised deck: " + revisedDeck.toString());
            ArrayList<Deck> tempDecks = this.ds.getDecks();
            for (Deck d : tempDecks) {
                if (d.getTitleOfDeck().equals(this.deck.getTitleOfDeck())) {
                    tempDecks.remove(d);
                    tempDecks.add(revisedDeck);
                    break;
                }
            }

            this.ds.setDecks(tempDecks);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("player.fxml"));
                Parent root = loader.load();
                PlayerController controller = loader.getController();
                controller.initPlayer(revisedDeck);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.selectedCard != null) {


            System.out.println("Edit card");
            ArrayList<Card> cards = this.deck.getCards();
            int indexOfCard = cards.indexOf(selectedCard);
            cards.set(indexOfCard, new Card(this.question, this.answer, this.color));
            this.deck.setCards(cards);
            Deck revisedDeck = this.deck;
            ArrayList<Deck> tempDecks = this.ds.getDecks();
            for (Deck d : tempDecks) {
                if (d.getTitleOfDeck().equals(this.deck.getTitleOfDeck())) {
                    tempDecks.remove(d);
                    tempDecks.add(revisedDeck);
                    break;
                }
            }

            this.ds.setDecks(tempDecks);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("player.fxml"));
            try {
                Parent root = loader.load();
                PlayerController controller = loader.getController();
                controller.initPlayer(revisedDeck);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void initEditor(Deck deck, Card selectedCard) {
        this.deck = deck;
        this.selectedCard = selectedCard;
        this.question = selectedCard.getQuestion();
        this.answer = selectedCard.getAnswer();
        this.color = selectedCard.getColor();
        questionTextArea.setText(selectedCard.getQuestion());
        answerTextArea.setText(selectedCard.getAnswer());
        mainLabel.setText("Edit Card");
    }

}
