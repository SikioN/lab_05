package ru.sikion.commandManager.commands;

import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkerHandler;

import java.util.HashSet;

/**
 * Shows every element of the collection in toString() interpretation.
 *
 * @since 1.0
 * @author Sikion
 */
public class ShowCommand implements BaseCommand {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescr() {
        return "Shows every element of the collection in toString() interpretation.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Worker>, Worker> handler = WorkerHandler.getInstance();

        handler.getCollection().forEach(System.out::println);

        if (handler.getCollection().isEmpty())
        {
            System.out.println("There's nothing to show.");
        }
    }
}
