package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Word
{
    String word;
    ArrayList<Character> usedLetters;
    ArrayList<Character> leftLetters;
    int numberOfLetters;

    public Word()
    {
        ArrayList<Character> leftLetters = new ArrayList<Character>(
                Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')); // 26 letters
        ArrayList<Character> usedLetters = new ArrayList<Character>();
        // word = bringWordFromText();  //TODO Delete from comment
        //numberOfLetters = word.length();
    }


    /*
    Method that return word from words file
     */
    private void bringWordFromText()
    {
        // TODO change to method that return String from the file
    }

    /*
    Method that return if the cat already used
     */
    public boolean charUse(char letter)
    {
        for (int i = 0 ; i < usedLetters.size() ; i++)
        {
            if (this.usedLetters.get(i) == letter)
            {
                return true;
            }
        }
        return false;
    }

}
