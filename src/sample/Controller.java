package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javax.swing.*;


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


    public void initialize()
    {
        gc = cnv.getGraphicsContext2D();
        lettersButtons();
        wordLettersBtn();
    }

    public void restart()
    {
        game.restart();
        for (int i = 0 ; i < game.getOrgans().size() ; i++ )
        {
            game.getOrgans().get(i).remove(gc);
        }
    }

    public void lettersButtons()
    {
        final int COLUMNS = 13;
        final int ROWS = 2;
        int column = 0;
        int row = 0;

        AllLettersBtn = new Button[COLUMNS*ROWS];


        for (int i = 0 ; i < COLUMNS*ROWS ; i++ )
        {
            // TODO: set buttons place(
            AllLettersBtn[i] = new Button((char)(97+i) + "");
            AllLettersBtn[i].setPrefSize(allLetters.getPrefWidth()/COLUMNS, allLetters.getPrefHeight()/ROWS);
            allLetters.add(AllLettersBtn[i], column , row);
            column ++;
            if (column == COLUMNS)
            {
                column = 0;
                row = 1;
            }
            final char curLetter = (char)(i+97);
            AllLettersBtn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    handleButtonAction(event,curLetter);
                }
            });

        }
    }

    private void handleButtonAction(ActionEvent event, char c)
    {
        Button temp = (Button)event.getSource();
        int guessCorrection = 0;

        /*
        If a letter appears in a word more than once then we will delete all its occurrences
         */
        int rightGuess = 0; // This variable make sure that if we right we don't enter the wrong letter place
        while(guessCorrection != -1)
        {
            guessCorrection = game.getWord().rightLetter(c);
            if (guessCorrection != -1)
            {
                rightGuess = 1;
                rightLetter(guessCorrection);
                game.addOneToRightGuesses();
                if (game.getRightGuess() == game.getWordLength())
                {
                    game.win();
                }
            }
            else if (rightGuess == 0)
            {
                wrongLetter();

                if (game.getWrongGuesses() == 6)
                {
                    game.lose();
                }
            }
        }

    }


    public void wordLettersBtn()
    {
        int cells =  game.getWordLength();
        wordLettersBtn = new Button[cells];

        for (int i = 0 ; i < cells ; i++ )
        {
            wordLettersBtn[i] = new Button("_");
            wordLettersBtn[i].setPrefSize(allLetters.getPrefWidth() / cells, allLetters.getPrefHeight());
            wordLetters.add(wordLettersBtn[i], i, 0);
        }
    }

    private void wrongLetter()
    {
        game.getOrgans().get(game.getWrongGuesses()).display(gc);
        game.addOneToWrongGuesses();
     }

    private void rightLetter(int number)
    {
        wordLettersBtn[number].setText(game.getWord().getWordLetters().get(number) + "");
        game.getWord().getWordLetters().set(number, '0');
        game.getWord().getWordLettersIndexes().set(number, -1);

    }

}
