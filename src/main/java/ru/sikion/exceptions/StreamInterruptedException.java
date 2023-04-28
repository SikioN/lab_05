package ru.sikion.exceptions;

import ru.sikion.models.Utilites.CodeColor;

public class StreamInterruptedException extends Exception {
    public StreamInterruptedException(String message) {
        super(CodeColor.RED + message + CodeColor.NONCOLOR);
    }
}
