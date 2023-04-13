package ru.sikion.exceptions;

public class CommandInterruptedException extends RuntimeException {
    public CommandInterruptedException(Exception cause)
    {
        super(cause);
    }
}
