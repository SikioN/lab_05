package ru.sikion.exceptions;

import ru.sikion.models.Utilites.CodeColor;

public class WrongAmountOfArgumentsException extends Exception {
    public WrongAmountOfArgumentsException(String message)
    {
        super(CodeColor.RED + message + CodeColor.NONCOLOR);
    }
}
