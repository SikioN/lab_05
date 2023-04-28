package ru.sikion.commandManager.commands;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.models.Worker;
import ru.sikion.models.comparators.WorkerSalaryComparator;
import ru.sikion.models.handlers.CollectionHandler;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.handlers.WorkersHandler;
import ru.sikion.models.handlers.userMode.WorkerCLIHandler;

import java.util.HashSet;

public class RemoveGreaterCommand implements BaseCommand{
    ModuleHandler<Worker> handler;

    /**
     * Default constructor with handler from 1.0
     */
    public RemoveGreaterCommand()
    {
        handler = new WorkerCLIHandler();
    }

    /**
     * Provides choosing handler
     *
     * @since 1.1
     * @param handler ModuleHandler for operating
     */
    public RemoveGreaterCommand(ModuleHandler<Worker> handler)
    {
        this.handler = handler;
    }
    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescr() {
        return "Removes elements from collection greater than given in argument. Comparing is set by salary.";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }
    @Override
    public void execute(String[] args) throws BuildObjectException {
        WorkerSalaryComparator comparator = new WorkerSalaryComparator();

        CollectionHandler<HashSet<Worker>, Worker> collectionHandler = WorkersHandler.getInstance();

        Worker greaterThan = handler.buildObject();
        System.out.println("Salary: " + greaterThan.getSalary());
        var iterator = collectionHandler.getCollection().iterator();

        int count = 0;

        while (iterator.hasNext())
        {
            var current = iterator.next();
            System.out.print("Comparing: current -- " + current.getSalary() + " vs " + greaterThan.getSalary());
            if (comparator.compare(current, greaterThan) > 0)
            {
                System.out.println(" -- Greater / Removing...");
                System.out.println("Removing element: " + current);
                iterator.remove();
                count++;
            }
            else
            {
                System.out.println(" -- Lower.");
            }
        }

        System.out.println("Total removed " + count + " elements");
    }
}