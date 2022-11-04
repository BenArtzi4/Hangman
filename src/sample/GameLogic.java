package sample;

import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    private int wrongGuesses;
    private int rightGuess;
    private Word word;
    private ArrayList<Organ> organs;
    int wordLength;
    boolean gameFinish;



    public GameLogic() throws IOException {
        restart();
        wordLength = this.word.getWord().length();
        Organ head = new Head();
        Organ body = new Body();
        Organ rHand = new RightHand();
        Organ lHand = new LeftHand();
        Organ rLeg = new RightLeg();
        Organ lLeg = new LeftLeg();
        this.organs = new ArrayList<Organ>(Arrays.asList(head, body, rHand, lHand, rLeg, lLeg));
        gameFinish = false;
    }

    public int getRightGuess() {
        return rightGuess;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public Word getWord() {
        return word;
    }

    public ArrayList<Organ> getOrgans() {
        return organs;
    }

    public boolean isGameFinish() {
        return gameFinish;
    }

    public void setGameFinish(boolean gameFinish) {
        this.gameFinish = gameFinish;
    }

    public void restart() throws IOException {
        this.rightGuess = 0;
        this.wrongGuesses = 0;
        this.word = new Word();
    }

    public void addOneToWrongGuesses()
    {
        this.wrongGuesses++;
    }

    public void addOneToRightGuesses() {
        this.rightGuess++;
    }

    public void lose() throws IOException {
        JOptionPane.showMessageDialog(null, "You have reached the maximum number of wrong guesses", "You Lose", JOptionPane.ERROR_MESSAGE);
        askForOneMoreGame();
    }


    public void win() throws IOException {
        JOptionPane.showMessageDialog(null, "congratulation\nYou Won!", "Good Game", JOptionPane.INFORMATION_MESSAGE);
        askForOneMoreGame();
    }

    public void askForOneMoreGame() throws IOException {
        int answer = JOptionPane.showConfirmDialog(null,"Would you like to play again?", "Hangman", JOptionPane.YES_NO_OPTION);
        if (answer == 0)
        {
            restart();
            gameFinish = true;

        }
        else
        {
            System.exit(0);
        }
    }

}
