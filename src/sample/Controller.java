package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class Controller {

    @FXML
    private GridPane allLetters;

    @FXML
    private GridPane wordLetters;

    @FXML
    private Canvas cnv;

    public static GraphicsContext gc;

    GameLogic game = new GameLogic();

    private Button[] AllLettersBtn;

    private Button[] wordLettersBtn;


    public void initialize() {
        gc = cnv.getGraphicsContext2D();
        lettersButtons();
        CreateWordLettersBtn();
        for (int i = 0; i < game.getOrgans().size(); i++) {
            System.out.println(game.getOrgans().get(i) + "" + i);
        }
    }

    public void restart() {
        game.restart();
        for (int i = 0; i < game.getOrgans().size(); i++) {
            game.getOrgans().get(i).remove(gc);
        }
    }

    public void lettersButtons() {
        final int COLUMNS = 13;
        final int ROWS = 2;
        int column = 0;
        int row = 0;

        AllLettersBtn = new Button[COLUMNS * ROWS];


        for (int i = 0; i < COLUMNS * ROWS; i++) {
            // TODO: set buttons place(
            AllLettersBtn[i] = new Button((char) (97 + i) + "");
            AllLettersBtn[i].setPrefSize(allLetters.getPrefWidth() / COLUMNS, allLetters.getPrefHeight() / ROWS);
            allLetters.add(AllLettersBtn[i], column, row);
            column++;
            if (column == COLUMNS) {
                column = 0;
                row = 1;
            }
            final char curLetter = (char) (i + 97);
            AllLettersBtn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleButtonAction(event, curLetter);
                }
            });

        }
    }

    private void handleButtonAction(ActionEvent event, char c) {
        if (game.getWrongGuesses() > 5) {
            game.lose();
        } else {
            int rightGuess = isLetterCorrect(event, c);

            if (rightGuess == 0) {
                wrongLetter(event);
            }
            if (game.getRightGuess() == game.getWordLength()) {
                game.win();
            }
        }

        if (game.isGameFinish()) {
            gc.clearRect(0, 0, cnv.getWidth(), cnv.getHeight());
            CreateWordLettersBtn();
            game.setGameFinish(false);
            activateAllLettersButtons();
        }

    }

    public void CreateWordLettersBtn() {
        wordLetters.getChildren().removeAll();
        int cells = game.getWordLength();
        wordLettersBtn = new Button[cells];

        for (int i = 0; i < cells; i++) {
            wordLettersBtn[i] = new Button("_");
            wordLettersBtn[i].setPrefSize(allLetters.getPrefWidth() / cells, allLetters.getPrefHeight());
            wordLetters.add(wordLettersBtn[i], i, 0);
        }
    }

    private void wrongLetter(ActionEvent event) {
        game.getOrgans().get(game.getWrongGuesses()).display(gc);
        game.addOneToWrongGuesses();
        ((Button) event.getSource()).setText("");
        ((Button) event.getSource()).setDisable(true);

        if (game.getWrongGuesses() == 7) {
            game.lose();
        }

    }

    public int isLetterCorrect(ActionEvent event, char c) {
        int counter = 0;
        for (int i = 0; i < game.getWordLength(); i++) {
            if (game.getWord().getWordLetters().get(i) == c && game.getWord().getWordLettersIndexes().get(i) != -1) {
                counter++;
                rightLetter(i, c, event);
                game.addOneToRightGuesses();
            }
        }
        return counter;
    }

    private void rightLetter(int index, char c, ActionEvent event) {
        wordLettersBtn[index].setText(c + "");
        ((Button) event.getSource()).setText("");
        ((Button) event.getSource()).setDisable(true);
        game.getWord().getWordLetters().set(index, '0');
        game.getWord().getWordLettersIndexes().set(index, -1);
    }

    public void activateAllLettersButtons()
    {
        final int COLUMNS = 13;
        final int ROWS = 2;
        int column = 0;
        int row = 0;
        for (int i = 0; i < COLUMNS * ROWS; i++) {
            AllLettersBtn[i].setText((char) (97 + i) + "");
            AllLettersBtn[i].setDisable(false);
            column++;
            if (column == COLUMNS) {
                column = 0;
                row = 1;
            }
        }

    }
}
