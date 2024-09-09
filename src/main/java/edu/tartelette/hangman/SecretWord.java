package edu.tartelette.hangman;


import java.util.HashSet;

public class SecretWord {
    private static final String secretWord = RandomWord.getRandomWord().toUpperCase();

    private static StringBuilder visibleWord;

    {
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

    public static void refresh() {
        new SecretWord();
    }

    public static String getSecretWord() {
        return secretWord;
    }

    private SecretWord() {
    }
}
