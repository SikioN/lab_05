package ru.sikion.exceptions;

import ru.sikion.models.Utilites.CodeColor;

public class BuildObjectException extends Exception {
    public BuildObjectException(String message)
    {
        super(CodeColor.RED + message + CodeColor.NONCOLOR);
    }
}
