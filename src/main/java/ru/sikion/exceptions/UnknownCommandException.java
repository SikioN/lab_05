package ru.sikion.exceptions;

import ru.sikion.models.Utilites.CodeColor;

/**
 * Provides a simple exception, indicates that command isn't found in manager
 */
public class UnknownCommandException extends Exception {
    /**
     * Constructor with message.
     *
     * @param message Message to show
     */
    public UnknownCommandException(String message)
    {
        super(CodeColor.RED + message + CodeColor.NONCOLOR);
    }
}
