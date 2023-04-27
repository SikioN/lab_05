package ru.sikion.main;

import ru.sikion.exceptions.StreamInterruptedException;
import ru.sikion.exceptions.WrongAmountOfArgumentsException;

import java.util.Scanner;

public class Utilities {
    public static boolean isNotNumeric(String str) {
        return !str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static Integer handleUserInputID(String input) {
        if (Utilities.isNotNumeric(input)) {
            System.out.println("Provided argument id: \"" + input + "\" is not a number! Try again.");
            return null;
        } else if (input.contains(".")) {
            System.out.println("ID field cannot accept decimal values. Try again.");
            return null;
        }

        int id = 0;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Provided argument: \"" + input + "\" is too large for ID field. Try again.");
        }
        return id;
    }

    public static void checkArgumentsOrThrow(int provided, int expected) throws WrongAmountOfArgumentsException {
        if (provided - 1 != expected)
            throw new WrongAmountOfArgumentsException("Provided " + (provided - 1) + " arguments, expected " + expected);
    }

    public static boolean hasNextLineOrThrow(Scanner scanner) throws StreamInterruptedException {
        if (scanner.hasNextLine()) return true;
        else throw new StreamInterruptedException("The input stream was stopped prematurely.");
    }
}
