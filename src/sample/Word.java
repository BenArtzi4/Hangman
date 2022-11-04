package sample;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Word
{
    private String word;

    private ArrayList<Character> wordLetters;
    private ArrayList<Integer> wordLettersIndexes;



    public Word()
    {

        word = "aabbccdd"; //TODO change word!!!!!!!!
        // word = bringWordFromText();  //TODO Delete from comment
        this.wordLetters = new ArrayList<Character>();
        this.wordLettersIndexes = new ArrayList<Integer>();

        for (int i = 0 ; i < word.length() ; i++)
        {
            this.wordLetters.add(i, word.charAt(i));
            this.wordLettersIndexes.add(i,i);
        }
    }

    public ArrayList<Character> getWordLetters() {
        return wordLetters;
    }

    public ArrayList<Integer> getWordLettersIndexes() {
        return wordLettersIndexes;
    }

    public String getWord() {
        return word;
    }


    /*
        Method that return word from words file
         */
    private void bringWordFromText()
    {
        // TODO change to method that return String from the file
    }

    private void getNewWord()
    {
        File file = new File("WordDate.txt");

    }





}
