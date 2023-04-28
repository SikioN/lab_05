package ru.sikion.commandManager.commands;

import ru.sikion.models.Utilites.CodeColor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Terminates the application (without saving collection).
 *
 * @since 1.0
 * @author Sikion
 */
public class ExitCommand implements BaseCommand {

    private static final Logger myLogger = Logger.getLogger("com.github.Sikion.lab5");
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescr() {
        return "Terminates the application (without saving collection).";
    }

    @Override
    public void execute(String[] args) {
        myLogger.log(Level.FINE, CodeColor.RUBIN + "Exit the program" + CodeColor.NONCOLOR);
        System.exit(0);
    }
}
