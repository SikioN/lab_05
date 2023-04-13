package ru.sikion.commandManager;

import ru.sikion.exceptions.CommandInterruptedException;

import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for executing commands. Provides different inputs for command executing.
 */
public class CommandExecutor {
    private static final Logger myLogger = Logger.getLogger("com.github.Sikion.lab5");

    /**
     * Start executing commands from InputStream.
     *
     * @param input commands stream (File, System.in, e.t.c.)
     * @param mode  variant of command behavior (see CommandMode enum)
     */
    public void startExecuting(InputStream input, CommandMode mode) {
        Scanner cmdScanner = new Scanner(input);
        CommandManager commandManager = new CommandManager(mode, cmdScanner);
        while (cmdScanner.hasNext()) {
            String line = cmdScanner.nextLine();
            if (line.isEmpty()) continue;
            try {
                commandManager.executeCommand(line.split(" "));
            } catch (CommandInterruptedException ex) {
                if (mode.equals(CommandMode.CLI_UserMode))
                    myLogger.log(Level.INFO, "The execution of the command was aborted. You can continue. The program has been returned to a secure state.");
                else
                    myLogger.log(Level.INFO, "The command has been skipped... The handler is still working");
            }
        }
    }
}