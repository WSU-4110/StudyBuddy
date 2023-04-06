package com.example.studybuddy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PlayerController extends SceneController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private boolean showAnswer = false;
    private Card selectedCard;
    private Deck deck;
    private DataHandlingCard ds = DataHandlingCard.getInstance();

    @FXML
    Label playerTitle;
    @FXML
    ListView<String> cardList;
    @FXML
    Label questionLabel;
    @FXML
    Button toggleAnswerBtn;

    @FXML
    Slider FontS;
    /**
     * Return to Main Screen
     *
     * @param event
     */

    public void switchToMain(ActionEvent event) {

        System.out.println("Switch to main");
        try {
            root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchToEditor(ActionEvent event) {

        if (selectedCard != null) {
            System.out.println("Switch to editor");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editor.fxml"));
            try {
                root = loader.load();
                EditorController controller = loader.getController();
                controller.initEditor(deck, this.selectedCard);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading editor.fxml");
                e.printStackTrace();
            }
        } else {
            System.out.println("Select a card first");
        }
    }

    public void addCardToDeck(ActionEvent event) throws Exception {
        // todo implement add card to deck
        System.out.println("Create New Card ");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editor.fxml"));
        try {
            root = loader.load();
            EditorController controller = loader.getController();
            controller.initEditor(deck);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error loading editor.fxml");
            e.printStackTrace();
        }

    }

    public void onDeleteCard(ActionEvent event) {
        System.out.println("Delete Card");
        if (this.selectedCard != null) {
            this.deck.removeCard(selectedCard);
            selectedCard = null;
            // remove card from file and then read from file again to update UI
            // * Read from File

            ArrayList<Deck> tempDecks = this.ds.getDecks();
            // * find using old deck in the tempDecks and then replace with revisedDeck
            for (Deck d : tempDecks) {
                if (d.getTitleOfDeck().equals(this.deck.getTitleOfDeck())) {
                    tempDecks.remove(d);
                    tempDecks.add(this.deck);
                    break;
                }
            }
            // * Save to File
            this.ds.setDecks(tempDecks);

            if (this.deck != null) {
                playerTitle.setText(deck.getTitleOfDeck());
                // * Populate ListView with Questions from Deck
                ArrayList<String> questions = new ArrayList<String>();
                for (Card card : deck.getCards()) {
                    questions.add(card.getQuestion());
                }
                ObservableList<String> observableList = FXCollections.observableArrayList(questions);
                cardList.getItems().setAll(observableList);
                cardList.setPlaceholder(new Text("No Cards in Deck"));
                this.questionLabel.setText("No card Selected");

                attachEventHandlers();
                questionLabel.setBackground(new Background(new BackgroundFill(null, null,null)));

            } else {
                cardList.setPlaceholder(new Label("No cards found"));
                System.out.println("No Cards Available");
            }
        } else {
            System.out.println("Select a card first");
        }
    }


    public void initPlayer(Deck deck) {
        this.deck = deck;
        if (this.deck != null) {
            playerTitle.setText(deck.getTitleOfDeck());
            // * Populate ListView with Questions from Deck
            ArrayList<String> questions = new ArrayList<String>();
            for (Card card : deck.getCards()) {
                questions.add(card.getQuestion());
            }
            ObservableList<String> observableList = FXCollections.observableArrayList(questions);
            cardList.getItems().addAll(observableList);
            attachEventHandlers();
        } else {
            cardList.setPlaceholder(new Label("No cards found"));
            System.out.println("No Cards Available");
        }
    }

    // * attach event handlers to card items in list
    public void attachEventHandlers() {
        cardList.setOnMouseClicked(event -> {
            String selectedQuestion = cardList.getSelectionModel().getSelectedItem();
            System.out.println(selectedQuestion);
            // * find the selected card using the selected Question from the card List
            Card selectedCard = this.deck.getCards().stream()
                    .filter(card -> card.getQuestion().equals(selectedQuestion)).findAny().orElse(null);
            this.selectedCard = selectedCard;
            questionLabel.setText(selectedCard.getQuestion());
            questionLabel.setBackground(new Background(new BackgroundFill(selectedCard.getColor(), null,null)));
            this.toggleAnswer();
        });
    }

    public void toggleAnswer(ActionEvent event) {
        showAnswer = !showAnswer;
        if (showAnswer && selectedCard != null) {
            questionLabel.setText(selectedCard.getAnswer());
            toggleAnswerBtn.setText("Hide Answer");
        } else if (selectedCard != null) {
            questionLabel.setText(selectedCard.getQuestion());
            toggleAnswerBtn.setText("Show Answer");
        } else { // no card selected}
            System.out.println("No card selected");
        }
    }

    public void toggleAnswer() {
        showAnswer = !showAnswer;
        toggleAnswerBtn.setText("Show Answer");
    }

    public void FontC(MouseEvent event)
    {
        double x = FontS.getValue();
        FontS.setValue(x);
        questionLabel.setFont(Font.font("Verdana",x ));
    }
}
