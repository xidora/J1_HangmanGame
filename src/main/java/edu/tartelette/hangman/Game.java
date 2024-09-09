package edu.tartelette.hangman;

import java.util.HashSet;

import static edu.tartelette.hangman.HangManArt.printHangManArt;

public class Game {
    private int attemptsLeft = 6;
    private final HashSet<Character> inputtedLetters = new HashSet<>();
    private final HashSet<Character> secretLetters = SecretWord.getSecretLetters();
    private static final String WIN_TEXT = "You won";
    private static final String LOSE_TEXT = "You lost";
    private static Game INSTANCE = new Game();

    public static Game getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }
        return INSTANCE;
    }

    public void start() {
        while ((attemptsLeft > 0) && (!secretLetters.isEmpty())) {
            System.out.println("====================");
            printHangManArt(attemptsLeft);
            System.out.print("Attempts Left: " + attemptsLeft + "| ");
            System.out.println("Inputted Letters: " + inputtedLetters);
            System.out.println("Visible word: " + SecretWord.getVisibleWord());
            char letter = LetterInput.get();
            inputtedLetters.add(letter);
            if(checkLetter(letter)) {
                SecretWord.revealLetter(letter);
            } else {
                attemptsLeft--;
            }
        }
        System.out.println("====================");
        if (attemptsLeft > 0) {
            System.out.println(WIN_TEXT);
        } else {
            System.out.println(LOSE_TEXT);
            printHangManArt(attemptsLeft);
        }
        System.out.println("Secret Word is: " + SecretWord.getSecretWord());
        SecretWord.refresh();
        Game.flush();
        Choicer.start();
    }

    public HashSet<Character> getInputtedLetters() {
        return inputtedLetters;
    }

    private static void flush() {
        INSTANCE = new Game();
    }

    private boolean checkLetter(char letter) {
        if (secretLetters.contains(letter)) {
            secretLetters.remove(letter);
            return true;
        } else {
            return false;
        }
    }

    private Game() {}
}
