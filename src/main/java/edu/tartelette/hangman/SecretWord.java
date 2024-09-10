package edu.tartelette.hangman;

import java.util.HashSet;

public class SecretWord {

    private String secretWord = RandomWord.getRandomWord().toUpperCase();
    private StringBuilder visibleWord = getHiddenWord();

    public SecretWord() {}

    public void revealLetter(char letter) {
        for (int i = 0; i < visibleWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                visibleWord.replace(i, i + 1, letter +"");
            }
        }
    }

    public String getVisibleWord() {
        return visibleWord.toString();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public HashSet<Character> getStartLetters() {
        HashSet<Character> secretLetters = new HashSet<>();
        for (int i = 0; i < secretWord.length(); i++) {
            secretLetters.add(secretWord.charAt(i));
        }
        return secretLetters;
    }

    private StringBuilder getHiddenWord() {
        StringBuilder hiddenWord = new StringBuilder();
        for(int i = 0; i < secretWord.length(); i++) {
            hiddenWord.append("*");
        }
        return hiddenWord;
    }
}
