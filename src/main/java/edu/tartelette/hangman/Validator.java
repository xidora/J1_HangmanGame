package edu.tartelette.hangman;

public class Validator {

    protected static boolean isValid(char inputChar) {
        return ((inputChar >= 'А') && (inputChar <= 'Я'));
    }

    private Validator() {}
}
