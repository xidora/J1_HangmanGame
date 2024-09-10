package edu.tartelette.hangman;

import java.util.HashSet;

import static java.lang.Character.toUpperCase;

public class Validator {
    private static String inputString;
    private static HashSet<Character> inputtedLetters;
    private static String outputString = "";

    public static boolean isValid() {
        if (inputString.length() != 1) {
            outputString = "Isn't a sungle letter";
            return false;
        }

        char letter = toUpperCase(inputString.charAt(0));
        if (!((letter >= 'А') && (letter <= 'Я'))) {
            outputString = "Isn't in the range[а-яА-Я]";
            return false;
        }

        if (inputtedLetters.contains(letter)) {
            outputString = "Used letter";
            return false;
        }
        return true;
    }

    public static String getOutputString() {
        return outputString;
    }

    public static void set (String inputString, HashSet<Character> inputtedLetters) {
        Validator.inputString = inputString;
        Validator.inputtedLetters = inputtedLetters;
    }

    private Validator() {}
}
