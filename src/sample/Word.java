package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Word
{
    private String word;

    private ArrayList<Character> wordLetters;
    private ArrayList<Integer> wordLettersIndexes;



    public Word() throws IOException {

        word = getNewWord(); //TODO change word!!!!!!!!
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

    private String getNewWord() throws IOException {
        final int NUMBER_OF_LINES = 7;
        Random rn = new Random();
        int wordNUmber = rn.nextInt(7);
        int counter = 0;
        FileReader fileReader = new FileReader("WordData.txt");
        BufferedReader buffReader = new BufferedReader(fileReader);
        String newWOrd = buffReader.readLine();

        while (counter != wordNUmber)
        {
            newWOrd = buffReader.readLine();
            counter++;
        }
        System.out.println(newWOrd);
        return newWOrd;



    }





}
