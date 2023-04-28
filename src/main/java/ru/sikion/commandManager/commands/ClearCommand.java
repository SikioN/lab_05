package ru.sikion.commandManager.commands;

import ru.sikion.models.Utilites.CodeColor;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkersHandler;

import java.util.HashSet;

/**
 * Clears collection
 *
 * @since 1.0
 * @author Sikion
 */
public class ClearCommand implements BaseCommand {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescr() {
        return "Clears collection";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkersHandler.getInstance();

        collectionHandler.clearCollection();

        System.out.println(CodeColor.GREEN + "Cleared!" + CodeColor.NONCOLOR);
    }
}
