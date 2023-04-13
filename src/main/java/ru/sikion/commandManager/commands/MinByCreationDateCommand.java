package ru.sikion.commandManager.commands;

import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkerHandler;

import java.util.Date;
import java.util.HashSet;

/**
 * Returns element from collection with min creation date.
 *
 * @since 1.0
 * @author Sikion
 */
public class MinByCreationDateCommand implements BaseCommand{
    @Override
    public String getName() {
        return "min_by_creation_date";
    }

    @Override
    public String getDescr() {
        return "Returns element from collection with min creation date.";
    }

    @Override
    public void execute(String[] args) {
        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkerHandler.getInstance();
        Date min = collectionHandler.getCollection().stream().map(Worker::getCreationDate).min(Date::compareTo).orElse(null);

        if (min == null)
        {
            System.out.println("There's nothing to show...");
        }
        else
        {
            for (Worker obj : collectionHandler.getCollection()) {
                if (obj.getCreationDate().equals(min))
                    System.out.println(obj);
            }
        }
    }
}
