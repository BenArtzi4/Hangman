package sample;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    private int wrongGuesses;
    private int rightGuess;
    private Word word;
    private ArrayList<Organ> organs;
    int wordLength;


    public GameLogic()
    {
        restart();
        wordLength = this.word.getWord().length();
        Organ head = new Head();
        Organ body = new Body();
        Organ rHand = new RightHand();
        Organ lHand = new LeftHand();
        Organ rLeg = new RightLeg();
        Organ lLeg = new LeftLeg();
        this.organs = new ArrayList<Organ>(Arrays.asList(head, body, rHand, lHand, rLeg, lLeg));
    }

    public int getRightGuess() {
        return rightGuess;
    }

    public int getWordLength() {
        return wordLength;
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

    public void restart()
    {
        rightGuess = 0;
        wrongGuesses = 0;
        this.word = new Word();
    }

    public void addOneToWrongGuesses() {
        this.wrongGuesses++;
    }

    public void addOneToRightGuesses() {
        this.rightGuess++;
    }


    public void lose()
    {
        JOptionPane.showMessageDialog(null, "You have reached the maximum number of wrong guesses", "You Lose", JOptionPane.ERROR_MESSAGE);
        askForOneMoreGame();
    }


    public void win()
    {
        JOptionPane.showMessageDialog(null, "congratulation\nYou Won!", "Good Game", JOptionPane.INFORMATION_MESSAGE);
        askForOneMoreGame();
    }

    public void askForOneMoreGame()
    {
        int answer = JOptionPane.showConfirmDialog(null,
                "Would you like to play again?", "Hangman", JOptionPane.YES_NO_OPTION);
        if (answer == 0)
        {
            restart();
        }
        System.exit(0);

    }
}
