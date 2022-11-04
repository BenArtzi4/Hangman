package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    private int wrongGuesses;
    private Word word = new Word();
    private ArrayList<Organ> organs;

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public Word getWord() {
        return word;
    }

    public ArrayList<Organ> getOrgans() {
        return organs;
    }

    public GameLogic()
    {
        restart();
        Organ head = new Head();
        Organ body = new Body();
        Organ rHand = new RightHand();
        Organ lHand = new LeftHand();
        Organ rLeg = new RightLeg();
        Organ lLeg = new LeftLeg();
        this.organs = new ArrayList<Organ>(Arrays.asList(head, body, rHand, lHand, rLeg, lLeg));
    }

    public void restart()
    {
        wrongGuesses = 0;
    }

    /*
    TODO add pop up message of "letter allready used
     */
    public void usedLetterAlert()
    {

    }

    public void wrongLetter()
    {

    }

    public void rightLetter()
    {

    }
}
