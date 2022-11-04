package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogic {
    int wrongGuesses;
    Word word = new Word();
    ArrayList<Organ> organs;



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
}
