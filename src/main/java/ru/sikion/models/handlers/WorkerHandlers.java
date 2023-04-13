package ru.sikion.models.handlers;

import ru.sikion.models.Worker;
import ru.sikion.models.validators.IdValidator;
import ru.sikion.models.validators.Validator;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for handling Worker objects. Contains static methods.
 *
 * @since 1.1
 * @author Sikion
 */
public class WorkerHandlers {

    /**
     * Generates unique ID for Worker Object.
     *
     * @return value for ID field.
     */
    public static Long generateID()
    {
        CollectionHandler<HashSet<Worker>, Worker> handler = WorkerHandler.getInstance();
        // id
        Validator<Integer> idValidator = new IdValidator();
        var lastObj = handler.getLastElement();
        long lastId = 1L;
        if (lastObj != null)
        {
            lastId = lastObj.getId() + 1;
        }
        while (!idValidator.validate(lastId))
        {
            lastId = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        }
        System.out.println("ID Field (auto-generated): " + lastId);
        return lastId;
    }
}
