package ru.sikion.models.handlers.nonUserMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.models.Coordinates;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.handlers.WorkerHandlers;
import ru.sikion.models.validators.WorkerValidator;
import ru.sikion.models.validators.Validator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of Worker ModelHandler for non-User Mode.
 *
 * @since 1.1
 * @author Sikion
 */
public class WorkerNonCLIHandler implements ModuleHandler<Worker> {

    private static final Logger myLogger = Logger.getLogger("com.github.Sikion.lab5");

    Scanner scanner;

    /**
     * Constructor for setup handler's scanner.
     *
     * @param scanner Command scanner for reading argument
     */
    public WorkerNonCLIHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Worker buildObject() throws BuildObjectException {
        System.out.println("Generating object...");
        Worker result = new Worker();
        int valuesToRead = 12;
        int coordsIndex = 1;
        int fromIndex = 3;
        int toIndex = 7;
        ArrayList<String> values = new ArrayList<>(valuesToRead);

        for (int i = 0; i < valuesToRead && scanner.hasNextLine(); i++)
        {
            String line = scanner.nextLine();
            if (!line.isEmpty())
                values.add(line);
            else
            {
                values.add(null);

                if (i == coordsIndex)
                {
                    valuesToRead -= 1;
                    fromIndex -= 1;
                    toIndex -= 1;
                }

                if (i == fromIndex)
                {
                    valuesToRead -= 3;
                    toIndex -= 3;
                }

                if (i == toIndex)
                {
                    valuesToRead -= 3;
                }
            }
        }

        try {
            result.setId(WorkerHandlers.generateID());
            result.setName(values.get(0));
            System.out.println("Name: " + result.getName());
            if (values.get(coordsIndex) != null) {
                System.out.println("Generating coordinates...");
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Integer.parseInt(values.get(coordsIndex)));
                System.out.println("Coordinates X: " + coordinates.getX());
                coordinates.setY(Float.parseFloat(values.get(coordsIndex + 1)));
                System.out.println("Coordinates Y: " + coordinates.getY());
                result.setCoordinates(coordinates);
            }
            System.out.println("Coordinates: " + result.getCoordinates());
            System.out.println("Generated at: " + result.getCreationDate());
            System.out.println("Object generated! Validating result...");

            Validator<Worker> validator = new WorkerValidator();
            if (!validator.validate(result))
            {
                System.out.println("Object's invalid, skipping...");
                throw new BuildObjectException("The element created violates the limitations and cannot be added to the collection!");
            }
            System.out.println("Validate successful! Sending result...");

            return result;

        } catch (NumberFormatException | NullPointerException e)
        {
            myLogger.log(Level.WARNING, "The object will be skipped. Correct the script error and try again.");
            throw new BuildObjectException("The data provided to construct the object is incorrect. Use manual input or correct the command in the script.");
        }
    }

}
