package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class word
{
    String word;
    ArrayList<Character> usedLetters;
    ArrayList<Character> leftLetters;

    public word()
    {
        ArrayList<Character> leftLetters = new ArrayList<Character>(
                Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')); // 26 letters
        ArrayList<Character> usedLetters = new ArrayList<Character>();
        word = bringWordFromText();

    }


    /*
    Method that return word from words file
     */
    private String bringWordFromText()
    {

    }
    /*
    Method that return if the cat already used
     */
    public boolean charUse()
    {

    }


}
