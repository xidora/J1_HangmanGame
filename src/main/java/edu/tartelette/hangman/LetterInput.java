package edu.tartelette.hangman;

import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class LetterInput {

    private static final String INPUT_LETTER_TEXT = "Type new letter [а-яА-Я] :";

    public static char get(HashSet<Character> inputtedLetters) {
        Scanner aScanner = new Scanner(System.in);
        while (true) {
            System.out.println(INPUT_LETTER_TEXT);
            String input = aScanner.nextLine();
            Validator.set(input, inputtedLetters);
            if (Validator.isValid()) {
                return toUpperCase(input.charAt(0));
            }
            System.out.println(Validator.getOutputString());
        }
    }

    private LetterInput() {}
}
