package ru.sikion.commandManager.commands;

import ru.sikion.exceptions.WrongAmountOfArgumentsException;
import ru.sikion.fileLogic.Saver;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkerHandler;

import java.util.HashSet;

/**
 * Saves collection to file.
 *
 * @since 1.0
 * @author Sikion
 */
public class SaveCommand implements BaseCommand {
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescr() {
        return "Saves collection to file.";
    }

    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        System.out.println("Saving...");
        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkerHandler.getInstance();
        Saver<HashSet<Worker>, Worker> saver = new Saver<>(Worker.class);

        saver.saveCollection(collectionHandler.getCollection(), "lab5");

        System.out.println("Executed.");
    }
}
