package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
A class representing the word chosen for the game
 */
public class Word
{
    private String word;

    private ArrayList<Character> wordLetters;


    /*
    A constructor that produces a word that has not yet been selected in the current game
     */
    public Word() throws IOException
    {
        word = getNewWord();
        this.wordLetters = new ArrayList<Character>();

        for (int i = 0 ; i < word.length() ; i++)
        {
            this.wordLetters.add(i, word.charAt(i));
        }
    }

    /*
    Getters
     */
    public ArrayList<Character> getWordLetters()
    {
        return wordLetters;
    }

    public String getWord()
    {
        return word;
    }

    /*
    Method that return word from words file
    */
    private String getNewWord() throws IOException
    {
        Random rn = new Random();
        int wordNUmber = rn.nextInt(7);
        int counter = 0;
        try {
            FileReader fileReader = new FileReader("WordData.txt");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String newWOrd = buffReader.readLine();

            while (counter != wordNUmber)
            {
                newWOrd = buffReader.readLine();
                counter++;
            }
            return newWOrd;

        }catch (IOException e)
        {
            System.out.println("File not found");
        }
        return null;
    }
}
