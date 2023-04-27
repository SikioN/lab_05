package ru.sikion.models.handlers;

import ru.sikion.models.Worker;
import ru.sikion.models.comparators.WorkerComparator;
import ru.sikion.models.validators.*;

import java.time.Instant;
import java.util.*;

/**
 * Current implementation of CollectionsHandler for TreeMap of Worker.
 *
 * @since 1.0
 * @author Sikion
 */
public class WorkersHandler implements CollectionHandler<HashSet<Worker>, Worker> {

    private static WorkersHandler singletoneMoment;

    private HashSet<Worker> workers;
    private final Date initDate;

    private WorkersHandler() {
        workers = new HashSet<>();
        initDate = Date.from(Instant.now());
    }

    /**
     * Singletone moment.
     *
     * @return Single instance of handler.
     */
    public static WorkersHandler getInstance() {
        if (singletoneMoment == null)
            singletoneMoment = new WorkersHandler();
        return singletoneMoment;
    }

    /**
     * Returns actual collection reference.
     *
     * @return Current collection
     */
    @Override
    public HashSet<Worker> getCollection()
    {
        return workers;
    }

    /**
     * Overrides current collection by provided value.
     *
     * @param workers Collection
     */
    @Override
    public void setCollection(HashSet<Worker> workers) {
        this.workers = workers;
        validateElements();
        sort();
    }

    /**
     * Adds element to collection.
     *
     * @param e Element to add
     */
    @Override
    public void addElementToCollection(Worker e)
    {
        workers.add(e);
        sort();
    }

    @Override
    public void clearCollection() {
        workers.clear();
    }

    /**
     * Sorts elements by ID Field in Route.
     */
    @Override
    public void sort() {
        HashSet<Worker> sorted = new HashSet<>();

        for (Iterator<Worker> it = workers.stream().sorted(new WorkerComparator()).iterator(); it.hasNext(); ) {
            Worker sortedItem = it.next();

            sorted.add(sortedItem);
        }

        this.workers = sorted;
    }

    /**
     * Returns first element of collection.
     * @return First element of collection. If collection is empty, returns new object.
     */
    @Override
    public Worker getFirstOrNew()
    {
        if (workers.iterator().hasNext())
            return workers.iterator().next();
        else
            return new Worker();
    }

    @Override
    public Date getInitDate() {
        return initDate;
    }

    /**
     * Returns last element of collection.
     * @return Last element of collection of null if collection is empty
     */
    @Override
    public Worker getLastElement()
    {
        Worker result = null;
        for (Worker worker : workers) {
            result = worker;
        }
        return result;
    }

    /**
     * Validates all elements in collection
     */
    @Override
    public void validateElements() {
        HashSet<Integer> ids = new HashSet<>(getCollection().size());

        for (Iterator<Worker> it = getCollection().iterator(); it.hasNext(); ) {
            Worker toValid = it.next();
            Validator<Worker> validator = new WorkerValidator();

            if (!validator.validate(toValid) || !ids.add(toValid.getId()))
            {
                it.remove();
                System.out.println("Element removed from collection: " + toValid);
                System.out.println("This element violates the restriction of some fields. Check your file and fix it manually.");
            }
        }
    }


}
