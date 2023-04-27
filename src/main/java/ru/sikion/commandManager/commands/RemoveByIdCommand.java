package ru.sikion.commandManager.commands;

import ru.sikion.exceptions.WrongAmountOfArgumentsException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkersHandler;

import java.util.HashSet;
import java.util.Objects;

/**
 * Removes element from collection by id.
 *
 * @since 1.0
 * @author Sikion
 */
public class RemoveByIdCommand implements BaseCommand {

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescr() {
        return "Removes element from collection by id.";
    }
    @Override
    public String getArgs() {
        return "id";
    }
    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        Utilities.checkArgumentsOrThrow(args.length, 1);

        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkersHandler.getInstance();

        Integer finalId = Utilities.handleUserInputID(args[1]);
        if (finalId == null) return;

        collectionHandler.getCollection().removeIf(worker -> Objects.equals(worker.getId(), finalId));

        System.out.println("Executed.");
    }
}
