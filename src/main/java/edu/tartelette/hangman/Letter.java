package edu.tartelette.hangman;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Letter {

    private static final String INPUT_LETTER_TEXT = "Type new letter [а-яА-Я] :";

    public static char get() {
        Scanner aScanner = new Scanner(System.in);
        while (true) {
            System.out.println(INPUT_LETTER_TEXT);
            String input = aScanner.nextLine();
            char letter = toUpperCase(input.charAt(0));
            if ((input.length() > 1) || !(Validator.isValid(letter))) {
                System.out.println("Isn't a valid letter");
            } else if (Game.getInstance().getInputtedLetters().contains(letter)) {
                System.out.println("Used letter");
            } else {
                return letter;
            }
        }
    }
}
