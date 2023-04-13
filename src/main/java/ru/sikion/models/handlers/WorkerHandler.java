package ru.sikion.models.handlers;

import ru.sikion.models.Worker;
import ru.sikion.models.comparators.RouteComparator;
import ru.sikion.models.validators.*;

import java.time.Instant;
import java.util.*;

/**
 * Current implementation of CollectionsHandler for TreeMap of Worker.
 *
 * @since 1.0
 * @author Sikion
 */
public class WorkerHandler implements CollectionHandler<TreeMap<Worker>, Worker> {

    private static WorkerHandler singletonMoment;

    private TreeMap workers;
    private final Date initDate;

    private WorkerHandler() {
        workers = new TreeMap<>();
        initDate = Date.from(Instant.now());
    }

    /**
     * Singletone moment.
     *
     * @return Single instance of handler.
     */
    public static WorkerHandler getInstance() {
        if (singletonMoment == null)
            singletonMoment = new WorkerHandler();
        return singletonMoment;
    }

    /**
     * Returns actual collection reference.
     *
     * @return Current collection
     */
    @Override
    public TreeMap<Worker> getCollection()
    {
        return workers;
    }

    /**
     * Overrides current collection by provided value.
     *
     * @param workers Collection
     */
    @Override
    public void setCollection(TreeMap<Worker> workers) {
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
     * Sorts elements by ID Field in Worker.
     */
    @Override
    public void sort() {
        TreeMap sorted = new TreeMap<>();

        for (Iterator<Worker> it = workers.stream().sorted(new RouteComparator()).iterator(); it.hasNext(); ) {
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
        TreeMap ids = new TreeMap<Long, Object>(getCollection().size());

        for (Iterator<Worker> it = getCollection().iterator(); it.hasNext(); ) {
            Worker toValid = it.next();
            Validator<? extends Worker> validator = new WorkerValidator();

            if (!validator.validate(toValid) || !ids.add(toValid.getId()))
            {
                it.remove();
                System.out.println("Element removed from collection: " + toValid);
                System.out.println("This element violates the restriction of some fields. Check your file and fix it manually.");
            }
        }
    }

    /**
     * Gets min element by given comparator
     *
     * @param comparator Comparator to compare.
     * @return Min element or null if collection is empty
     */
    @Override
    public Worker getMin(Comparator<Worker> comparator) {

        return getCollection().stream().min(comparator).orElse(null);
    }

    /**
     * Gets max element by given comparator
     *
     * @param comparator Comparator to compare.
     * @return Max element or null if collection is empty
     */
    @Override
    public Worker getMax(Comparator<Worker> comparator) {
        return getCollection().stream().max(comparator).orElse(null);
    }
}
