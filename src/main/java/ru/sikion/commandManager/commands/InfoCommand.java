package ru.sikion.commandManager.commands;

import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkersHandler;

import java.util.HashSet;

/**
 * Shows information about the collection.
 *
 * @since 1.0
 * @author Sikion
 */
public class InfoCommand implements BaseCommand {
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescr() {
        return "Shows information about the collection.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Worker>, Worker> handler = WorkersHandler.getInstance();

        HashSet<Worker> collection = handler.getCollection();

        System.out.println("Now you are operating with collection of type " + collection.getClass().getName() + ", filled with elements of type " + handler.getFirstOrNew().getClass().getName());
        System.out.println("Size of the collection is " + collection.size());
        System.out.println("Init date: " + handler.getInitDate());
    }
}
