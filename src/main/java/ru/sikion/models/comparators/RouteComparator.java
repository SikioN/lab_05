package ru.sikion.models.comparators;

import ru.sikion.models.Worker;

import java.util.Comparator;

/**
 * Compare two Routes by ID (default used)
 *
 * @author Sikion
 * @since 1.0
 */
public class RouteComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
