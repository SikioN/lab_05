package ru.sikion.exceptions;

public class WrongAmountOfArgumentsException extends Exception {
    public WrongAmountOfArgumentsException(String msg)
    {
        super(msg);
    }
}
