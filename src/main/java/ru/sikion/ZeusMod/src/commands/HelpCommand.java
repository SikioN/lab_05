package ru.sikion.ZeusMod.src.commands;

import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.server.ServerConnection;
import java.util.HashMap;

/**
 * Класс {@code HelpCommand} переопределяет метод {@code execute ()} для отображения всех доступных команд
 * {@link AbstractCommand} в {@link ServerConnection}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class HelpCommand extends AbstractCommand {

    private HashMap<String, AbstractCommand> commands;

    public HelpCommand(CollectionManager manager, HashMap<String, AbstractCommand> commands) {
        super(manager);
        setDescription("Показывает список доступных команд.");
        this.commands = commands;
    }

    @Override
    public synchronized String execute() {
        return commands.keySet().toString() + "\nВведите 'more {command}' для получения справки по к команде.";
    }
}