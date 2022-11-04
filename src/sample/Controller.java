package sample;

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
        for (int i = 0 ; i < game.organs.size() ; i++ )
        {
            game.organs.get(i).display(gc);
        }

        drawLettersButtons();
    }

    public void restart()
    {
        game.restart();
        for (int i = 0 ; i < game.organs.size() ; i++ )
        {
            game.organs.get(i).remove(gc);
        }
    }

    public void drawLettersButtons()
    {
        final int COLUMNS = 13;
        final int ROWS = 2;
        int column = 0;
        int row = 0;

        AllLettersBtn = new Button[COLUMNS*ROWS];


        for (int i = 0 ; i < COLUMNS*ROWS ; i++ )
        {
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
        }
    }



}
