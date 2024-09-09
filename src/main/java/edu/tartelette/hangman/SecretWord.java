package edu.tartelette.hangman;


import java.util.HashSet;

public class SecretWord {
    private static String secretWord;
    private static StringBuilder visibleWord = new StringBuilder();
    private static SecretWord INSTANCE = new SecretWord();

    {
        secretWord = RandomWord.getRandomWord().toUpperCase();
        visibleWord = new StringBuilder();
        for(int i = 0; i < secretWord.length(); i++) {
            visibleWord.append("*");
        }
    }

    public static void revealLetter(char letter) {
        for (int i = 0; i < visibleWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                visibleWord.replace(i, i + 1, letter +"");
            }
        }
    }

    public static String getVisibleWord() {
        return visibleWord.toString();
    }

    public static HashSet<Character> getSecretLetters() {
        HashSet<Character> secretLetters = new HashSet<>();
        for (int i = 0; i < secretWord.length(); i++) {
            secretLetters.add(secretWord.charAt(i));
        }
        return secretLetters;
    }

    public static void flush() {
        INSTANCE = new SecretWord();
    }

    public static SecretWord getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SecretWord();
        }
        return INSTANCE;
    }

    private SecretWord() {
        secretWord = RandomWord.getRandomWord().toUpperCase();
        visibleWord = new StringBuilder();
        for(int i = 0; i < secretWord.length(); i++) {
            visibleWord.append("*");
        }
    }
}
