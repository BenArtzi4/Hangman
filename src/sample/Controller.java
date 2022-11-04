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

    public GraphicsContext gc;

    GameLogic game = new GameLogic();

    private Button[] AllLettersBtn;


    public void initialize()
    {
        gc = cnv.getGraphicsContext2D();
        for (int i = 0 ; i < game.getOrgans().size() ; i++ )
        {
            game.getOrgans().get(i).display(gc);
        }

        lettersButtons();
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
        final int letter = 97;

        AllLettersBtn = new Button[COLUMNS*ROWS];


        for (int i = 0 ; i < COLUMNS*ROWS ; i++ )
        {
            // TODO: set buttons place(
            AllLettersBtn[i] = new Button((char)(97+i) + "");
            AllLettersBtn[i].setPrefSize(allLetters.getPrefWidth()/COLUMNS, allLetters.getPrefHeight()/ROWS);
            allLetters.add(AllLettersBtn[i], column , row);
            System.out.println(row + "  " + column);
            column ++;
            if (column == COLUMNS)
            {
                column = 0;
                row = 1;
            }
            final char curLetter = (char)(i+97);
            AllLettersBtn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    handleButtonAction(curLetter);
                }
            });

        }
    }

    private void handleButtonAction(ActionEvent event, char c)
    {
        Button temp = (Button)event.getSource();
        if(game.getWord().isUse(c))
        {
            game.usedLetterAlert();
        }
        else
        {
            if (game.getWord().rightLetter(c))
            {
                game.rightLetter();
            }
            else
            {
                game.wrongLetter();
            }
        }
    }
}
