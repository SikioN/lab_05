package ru.sikion.models.validators;

import ru.sikion.models.Worker;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.WorkersHandler;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Implementation of validator for ID field. (Worker)
 *
 * @author Sikion
 * @since 1.0
 */
public class IdValidator implements Validator<Integer> {

    TreeSet<Integer> ids;


    /**
     * Setup validator default constructor
     */
    public IdValidator() {
        ids = new TreeSet<>();

        CollectionHandler<HashSet<Worker>, Worker> handler = WorkersHandler.getInstance();

        handler.getCollection().forEach((value) -> ids.add(value.getId()));
    }

    /**
     * Checks if value unique in collection, greater than 0 and notnull.
     *
     * @param value ID to validate
     * @return true/false -- matches the restrictions
     * @see Worker
     */

    @Override
    public boolean validate(Integer value) {
        if (value == null) return false;
        if (value <= 0) return false;
        return ids.add(value);
    }

}
