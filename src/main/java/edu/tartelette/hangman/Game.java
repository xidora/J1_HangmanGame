package edu.tartelette.hangman;

import java.util.HashSet;

import static edu.tartelette.hangman.HangManArt.printHangManArt;

public class Game {
    private int attemptsLeft = 6;
    private HashSet<Character> inputtedLetters = new HashSet<>();
    private HashSet<Character> secretLetters = SecretWord.getSecretLetters();
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
            System.out.println("===");
            printHangManArt(attemptsLeft);
            System.out.print("Attempts Left: " + attemptsLeft + "| ");
            System.out.println("Inputted Letters: " + inputtedLetters);
            System.out.println("Visible word: " + SecretWord.getVisibleWord());
            char letter = Letter.get();
            inputtedLetters.add(letter);
            if(checkLetter(letter)) {
                SecretWord.revealLetter(letter);
            } else {
                attemptsLeft--;
            }
        }
        System.out.println("attemptsLeft =" + attemptsLeft);
        System.out.println("secretLetters =" + secretLetters);
        if (attemptsLeft > 0) {
            System.out.println(WIN_TEXT);
        } else {
            System.out.println(LOSE_TEXT);
        }
        Game.flush();
        SecretWord.flush();
        Choicer.start();
    }

    public HashSet<Character> getInputtedLetters() {
        return inputtedLetters;
    }

    public void addSecretLetter(char letter) {
        secretLetters.add(letter);
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
