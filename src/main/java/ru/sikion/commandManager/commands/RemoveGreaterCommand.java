//package ru.sikion.commandManager.commands;
//
//import ru.sikion.exceptions.BuildObjectException;
//import ru.sikion.models.Worker;
//import ru.sikion.models.comparators.RouteDistanceComparator;
//import ru.sikion.models.handlers.CollectionHandler;
//import ru.sikion.models.handlers.ModuleHandler;
//import ru.sikion.models.handlers.WorkerHandler;
//import ru.sikion.models.handlers.userMode.RouteCLIHandler;
//
//import java.util.TreeMap;
//
///**
// * Removes elements from collection greater than given in argument.
// *
// * @since 1.0
// * @author Sikion
// */
//public class RemoveGreaterCommand implements BaseCommand {
//
//    ModuleHandler<Worker> handler;
//
//    /**
//     * Default constructor with handler from 1.0
//     */
//    public RemoveGreaterCommand()
//    {
//        handler = new RouteCLIHandler();
//    }
//
//    /**
//     * Provides choosing handler
//     *
//     * @since 1.1
//     * @param handler ModuleHandler for operating
//     */
//    public RemoveGreaterCommand(ModuleHandler<Worker> handler)
//    {
//        this.handler = handler;
//    }
//    @Override
//    public String getName() {
//        return "remove_greater";
//    }
//
//    @Override
//    public String getDescr() {
//        return "Removes elements from collection greater than given in argument. Comparing is set by distance.";
//    }
//
//    @Override
//    public String getArgs() {
//        return "{element}";
//    }
//    @Override
//    public void execute(String[] args) throws BuildObjectException {
//        RouteDistanceComparator comparator = new RouteDistanceComparator();
//
//        CollectionHandler<TreeMap<Worker>, Worker> collectionHandler = WorkerHandler.getInstance();
//
//        Worker greaterThan = handler.buildObject();
//        System.out.println("Distance: " + greaterThan.getDistance());
//        var iterator = collectionHandler.getCollection().iterator();
//
//        int count = 0;
//
//        while (iterator.hasNext())
//        {
//            var current = iterator.next();
//            System.out.print("Comparing: current -- " + current.getDistance() + " vs " + greaterThan.getDistance());
//            if (comparator.compare(current, greaterThan) > 0)
//            {
//                System.out.println(" -- Greater / Removing...");
//                System.out.println("Removing element: " + current);
//                iterator.remove();
//                count++;
//            }
//            else
//            {
//                System.out.println(" -- Lower.");
//            }
//        }
//
//        System.out.println("Removed " + count + " elements");
//    }
//}
