package sample;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic
{
    // A variable representing the number of wrong guesses by the user
    private int wrongGuesses;
    // A variable representing the number of right guesses by the user
    private int rightGuess;
    // An object representing the selected word
    private Word word;
    // An array containing the hanging man's organs
    private ArrayList<Organ> organs;
    // A variable representing length of the word
    int wordLength;
    // A variable that indicates whether the game is over or not
    boolean gameFinish;



    public GameLogic() throws IOException
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
        gameFinish = false;
    }

    /*
    Getters
     */

    public int getRightGuess()
    {
        return rightGuess;
    }

    public int getWordLength()
    {
        return wordLength;
    }

    public void setWordLength(int wordLength)
    {
        this.wordLength = wordLength;
    }

    public int getWrongGuesses()
    {
        return wrongGuesses;
    }

    public Word getWord()
    {
        return word;
    }

    public ArrayList<Organ> getOrgans()
    {
        return organs;
    }

    public boolean isGameFinish()
    {
        return gameFinish;
    }

    /*
    Setters
     */
    public void setGameFinish(boolean gameFinish)
    {
        this.gameFinish = gameFinish;
    }

    public void restart() throws IOException
    {
        this.rightGuess = 0;
        this.wrongGuesses = 0;
        this.word = new Word();
    }

    /*
    Adds one to the wrong guesses variable
     */
    public void addOneToWrongGuesses()
    {
        this.wrongGuesses++;
    }

    /*
    Adds one to the correct guesses variable
     */
    public void addOneToRightGuesses()
    {
        this.rightGuess++;
    }

    /*
    A method used in the event of losing a game
    */
    public void lose() throws IOException
    {
        JOptionPane.showMessageDialog(null, "You have reached the maximum number of wrong guesses\n" +
                "The word was: " + word.getWord(), "You Lose", JOptionPane.ERROR_MESSAGE);
        askForOneMoreGame();
    }


    /*
    Method used in case of winning the game
     */
    public void win() throws IOException
    {
        JOptionPane.showMessageDialog(null, "congratulation\nYou Won!", "Good Game", JOptionPane.INFORMATION_MESSAGE);
        askForOneMoreGame();
    }

    /*
    A method that checks whether the user wants to play another game and, if so, resets the relevant variables
     */
    public void askForOneMoreGame() throws IOException
    {
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
