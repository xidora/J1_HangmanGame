package edu.tartelette.hangman;

import static java.lang.Character.toUpperCase;

public class Validator {
    private static String inputString;
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

        if (Game.getInstance().getInputtedLetters().contains(letter)) {
            outputString = "Used letter";
            return false;
        }
        return true;
    }

    public static String getOutputString() {
        return outputString;
    }

    public static void set (String inputString) {
        Validator.inputString = inputString;
    }


}
