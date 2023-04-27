package ru.sikion.commandManager;

import ru.sikion.commandManager.commands.*;
import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.exceptions.CommandInterruptedException;
import ru.sikion.exceptions.UnknownCommandException;
import ru.sikion.exceptions.WrongAmountOfArgumentsException;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.handlers.nonUserMode.RouteNonCLIHandler;
import ru.sikion.models.handlers.userMode.WorkerCLIHandler;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Command Manager for interactive collection manage. For execute commands, use CommandExecutor class
 *
 * @see CommandExecutor
 * @since 1.0
 * @author Sikion
 */
public class CommandManager {

    private static final Logger myLogger = Logger.getLogger("com.github.Sikion.lab5");
    LinkedHashMap<String, BaseCommand> commands;

    /**
     * Setup command manager and all of its commands.
     */
    public CommandManager()
    {
        commands = new LinkedHashMap<>();

        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());
        commands.put("min_by_creation_date", new MinByCreationDateCommand());
    }

    /**
     * Constructor provides choice of commands behavior: ex. userMode or nonUserMode
     *
     * @since 1.1
     * @see CommandMode
     * @param mode Mode for CommandHandler
     * @param scanner Commands scanner
     */
    public CommandManager(CommandMode mode, Scanner scanner) {
        commands = new LinkedHashMap<>();
        
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());
        commands.put("min_by_creation_date", new MinByCreationDateCommand());

        ModuleHandler<Worker> handler = null;
        switch (mode)
        {
            case CLI_UserMode -> handler = new WorkerCLIHandler();
            case NonUserMode -> handler = new RouteNonCLIHandler(scanner);
        }

        commands.put("add", new AddCommand(handler));
        commands.put("update", new UpdateCommand(handler));
    }

    /**
     * Get all commands from manager.
     *
     * @return Map of loaded commands
     */
    public LinkedHashMap<String, BaseCommand> getCommands() {
        return commands;
    }

    /**
     * Universe method for command executing.
     *
     * @param args full separated line from stream
     */
    public void executeCommand(String[] args) {
        try {
            Optional.ofNullable(commands.get(args[0])).orElseThrow(() -> new UnknownCommandException("Указанная команда не была обнаружена")).execute(args);
        } catch (IllegalArgumentException | NullPointerException e) {
            myLogger.log(Level.SEVERE, "Выполнение команды пропущено из-за неправильных предоставленных аргументов! (" + e.getMessage() + ")");
            throw new CommandInterruptedException(e);
        } catch (BuildObjectException | UnknownCommandException e) {
            myLogger.log(Level.SEVERE, e.getMessage());
            throw new CommandInterruptedException(e);
        } catch (WrongAmountOfArgumentsException e) {
            myLogger.log(Level.SEVERE, "Wrong amount of arguments! " + e.getMessage());
            throw new CommandInterruptedException(e);
        } catch (Exception e) {
            myLogger.log(Level.SEVERE, "В командном менеджере произошла непредвиденная ошибка! " + e.getMessage());
            throw new CommandInterruptedException(e);
        }
    }
}
