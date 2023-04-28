package ru.sikion.commandManager.commands;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.exceptions.WrongAmountOfArgumentsException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.handlers.userMode.WorkerCLIHandler;
import ru.sikion.models.handlers.WorkersHandler;

import java.util.HashSet;
import java.util.Objects;

/**
 * Updates element by its ID.
 *
 * @since 1.0
 * @author Sikion
 */
public class UpdateCommand implements BaseCommand {

    ModuleHandler<Worker> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public UpdateCommand()
    {
        handler = new WorkerCLIHandler();
    }

    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public UpdateCommand(ModuleHandler<Worker> handler)
    {
        this.handler = handler;
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescr() {
        return "Updates element by ID.";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public void execute(String[] args) throws BuildObjectException, WrongAmountOfArgumentsException {
        Utilities.checkArgumentsOrThrow(args.length, 1);

        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkersHandler.getInstance();

        Integer finalId = Utilities.handleUserInputID(args[1]);
        if (finalId == null) return;

        if(!collectionHandler.getCollection().removeIf(worker -> Objects.equals(worker.getId(), finalId)))
        {
            System.out.println("Element with that id doesn't exists.");
            return;
        }
        Worker newObj = handler.buildObject();

        System.out.println("Updated ID value: " + finalId);
        newObj.setId(finalId);

        collectionHandler.addElementToCollection(newObj);

        System.out.println("Object updated!");
    }
}
