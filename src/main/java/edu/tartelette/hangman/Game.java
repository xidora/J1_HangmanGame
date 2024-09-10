package edu.tartelette.hangman;

import java.util.HashSet;

import static edu.tartelette.hangman.HangManArt.printHangManArt;

public class Game {
    private int attemptsLeft = 6;
    private final HashSet<Character> inputtedLetters = new HashSet<>();
    private SecretWord aSecretWord = new SecretWord();
    private HashSet<Character> secretLetters = aSecretWord.getStartLetters();

    private static final String WIN_TEXT = "You won";
    private static final String LOSE_TEXT = "You lost";
    private static final String GUESS_IS_RIGHT_TEXT = "Your guess is right";
    private static final String GUESS_IS_WRONG_TEXT = "Your guess is wrong";

    public Game() {}

    public void start() {
        while ((attemptsLeft > 0) && (!secretLetters.isEmpty())) {
            System.out.println("====================");
            printHangManArt(attemptsLeft);
            System.out.print("Attempts Left: " + attemptsLeft + "| ");
            System.out.println("Inputted Letters: " + inputtedLetters);
            System.out.println("Visible word: " + aSecretWord.getVisibleWord());
            char letter = LetterInput.get(inputtedLetters);
            inputtedLetters.add(letter);
            if(checkLetter(letter)) {
                aSecretWord.revealLetter(letter);
                System.out.println(GUESS_IS_RIGHT_TEXT);
            } else {
                System.out.println(GUESS_IS_WRONG_TEXT);
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
        System.out.println("Secret Word is: " + aSecretWord.getSecretWord());
        Choicer.start();
    }

    private boolean checkLetter(char letter) {
        if (secretLetters.contains(letter)) {
            secretLetters.remove(letter);
            return true;
        } else {
            return false;
        }
    }
}
