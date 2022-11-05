package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;


public class Controller
{

    @FXML
    private GridPane allLetters;

    @FXML
    private GridPane wordLetters;

    @FXML
    private Canvas cnv;

    @FXML
    private TextField txtField;

    public static GraphicsContext gc;

    GameLogic game = new GameLogic();

    private Button[] AllLettersBtn;

    private Button[] wordLettersBtn;

    public Controller() throws IOException{
    }


    /*
    Start the game and the relevant boards and choose a word from the text box
     */
    public void initialize()
    {
        gc = cnv.getGraphicsContext2D();
        lettersButtons();
        CreateWordLettersBtn();
        txtField.setText("Letters used: ");
    }


    /*
    Initializes all letters in the language for the game
     */
    public void lettersButtons()
    {
        final int COLUMNS = 13;
        final int ROWS = 2;
        int column = 0;
        int row = 0;

        AllLettersBtn = new Button[COLUMNS * ROWS];


        for (int i = 0; i < COLUMNS * ROWS; i++)
        {
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
            AllLettersBtn[i].setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    try
                    {
                        txtField.setText(txtField.getText() + ((Button) event.getSource()).getText() + " ");
                        handleButtonAction(event, curLetter);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    /*
    A method that is invoked when a letter is clicked and checks if it exists in the selected word
     */
    private void handleButtonAction(ActionEvent event, char c) throws IOException
    {
        if (game.getWrongGuesses() > 5)
        {
            game.lose();
        }
        else
        {
            int rightGuess = isLetterCorrect(event, c);

            if (rightGuess == 0)
            {
                wrongLetter(event);
            }
            if (game.getRightGuess() == game.getWordLength())
            {
                game.win();
            }
        }

        if (game.isGameFinish()) {
            hideButtons();
            gc.clearRect(0, 0, cnv.getWidth(), cnv.getHeight());
            game.setGameFinish(false);
            activateAllLettersButtons();
            game.setWordLength(this.game.getWord().getWord().length());
            CreateWordLettersBtn();
        }

    }

    /*
    A method that initializes the squares according to the length of the selected word
     */
    public void CreateWordLettersBtn()
    {
        int cells = game.getWordLength();
        wordLettersBtn = new Button[cells];

        for (int i = 0; i < cells; i++)
        {
            wordLettersBtn[i] = new Button("_");
            wordLettersBtn[i].setVisible(true);
            wordLettersBtn[i].setDisable(true);
            wordLettersBtn[i].setPrefSize(allLetters.getPrefWidth() / cells, allLetters.getPrefHeight());
            wordLetters.add(wordLettersBtn[i], i, 0);
        }
    }

    /*
    A method for changing the letters in case of changing a word
     */
    public void hideButtons()
    {
        int cells = game.getWordLength();
        for (int i = 0; i < cells; i++)
        {
            wordLettersBtn[i].setVisible(false);
        }
    }

    /*
    A method that updates the relevant panels and draws the member if the user has chosen a letter that is not in the word
     */
    private void wrongLetter(ActionEvent event) throws IOException {
        game.getOrgans().get(game.getWrongGuesses()).display(gc);
        game.addOneToWrongGuesses();
        ((Button) event.getSource()).setText("");
        ((Button) event.getSource()).setDisable(true);

        if (game.getWrongGuesses() == 7) {
            game.lose();
        }

    }

    /*
    A method that updates the relevant boards if the user has selected a letter in the word
     */
    private void rightLetter(int index, char c, ActionEvent event)
    {
        wordLettersBtn[index].setText(c + "");
        ((Button) event.getSource()).setText("");
        ((Button) event.getSource()).setDisable(true);
        game.getWord().getWordLetters().set(index, '0');
        game.getWord().getWordLettersIndexes().set(index, -1);
    }

    /*
    A method that checks whether the selected letter is in the word
     */
    public int isLetterCorrect(ActionEvent event, char c)
    {
        int counter = 0;
        for (int i = 0; i < game.getWordLength(); i++)
        {
            if (game.getWord().getWordLetters().get(i) == c)
            {
                counter++;
                rightLetter(i, c, event);
                game.addOneToRightGuesses();
            }
        }
        return counter;
    }


    /*
    A method that returns all the letters pressed in the previous game
     */
    public void activateAllLettersButtons()
    {
        final int COLUMNS = 13;
        final int ROWS = 2;
        for (int i = 0; i < COLUMNS * ROWS; i++)
        {
            AllLettersBtn[i].setText((char) (97 + i) + "");
            AllLettersBtn[i].setDisable(false);
        }
    }
}
