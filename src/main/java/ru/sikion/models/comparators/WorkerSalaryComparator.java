package ru.sikion.models.comparators;

import ru.sikion.models.Worker;

import java.util.Comparator;

/**
 * Compare two workers by salary
 *
 * @see Worker
 * @author Sikion
 * @since 1.0
 */

public class WorkerSalaryComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}

