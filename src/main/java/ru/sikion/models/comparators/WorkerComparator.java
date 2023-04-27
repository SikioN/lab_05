package ru.sikion.models.comparators;

import ru.sikion.models.Worker;

import java.util.Comparator;

/**
 * Compare two workers by ID (default used)
 *
 * @author Sikion
 * @since 1.0
 */
public class WorkerComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
