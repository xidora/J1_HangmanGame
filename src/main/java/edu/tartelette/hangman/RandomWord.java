package edu.tartelette.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {
    private static final ArrayList<String> libraryOfWords = new ArrayList<>();

    public static String getRandomWord() {
        RandomWord.getLibraryOfWords();
        Random aRandom = new Random();
        int wordsNumber = aRandom.nextInt(libraryOfWords.size());
        System.out.println("Rand = " +wordsNumber);
        return libraryOfWords.get(wordsNumber);
    }

    public static void getLibraryOfWords() {
        try {
            if (ClassLoader.getSystemResourceAsStream("dic.txt") == null) {
                throw new FileNotFoundException("File not found ");
            }
            Scanner aScanner = new Scanner(ClassLoader.getSystemResourceAsStream("dic.txt"));
            while (aScanner.hasNext()) {
                libraryOfWords.add(aScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            libraryOfWords.add("переворот");
        }
    }

    private RandomWord() {}
}
