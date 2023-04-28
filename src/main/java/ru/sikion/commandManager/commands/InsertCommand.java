package ru.sikion.commandManager.commands;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.models.handlers.*;
import ru.sikion.models.handlers.userMode.WorkerCLIHandler;
import ru.sikion.models.Worker;

import java.util.HashSet;

/**
 * Adds new element to collection.
 *
 * @since 1.0
 * @author Sikion
 */
public class InsertCommand implements BaseCommand {
    ModuleHandler<Worker> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public InsertCommand()
    {
        handler = new WorkerCLIHandler();
    }
    /**
     * Provides choosing handler
     *
     * @param handler ModuleHandler for operating
     */
    public InsertCommand(ModuleHandler<Worker> handler)
    {
        this.handler = handler;
    }

    @Override
    public String getName() {
        return "Insert";
    }

    @Override
    public String getDescr() {
        return "Inserts new element to collection.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) throws BuildObjectException {
        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkersHandler.getInstance();

        collectionHandler.addElementToCollection(handler.buildObject());

        System.out.println("Element inserted!");
    }
}
