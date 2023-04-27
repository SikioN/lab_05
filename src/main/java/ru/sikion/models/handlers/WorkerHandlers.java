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
    public static int generateID()
    {
        CollectionHandler<HashSet<Worker>, Worker> handler = WorkersHandler.getInstance();

        Validator<Integer> idValidator = new IdValidator();
        var lastObj = handler.getLastElement();
        int lastId = 1;
        if (lastObj != null)
        {
            lastId = Math.toIntExact(lastObj.getId() + 1);
        }
        while (!idValidator.validate(lastId))
        {
            lastId = Math.toIntExact(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE));
        }
        System.out.println("ID Field (auto-generated): " + lastId);
        return lastId;
    }
}
