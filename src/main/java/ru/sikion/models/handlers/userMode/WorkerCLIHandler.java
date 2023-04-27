package ru.sikion.models.handlers.userMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.exceptions.StreamInterruptedException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.*;
import ru.sikion.models.validators.NameValidator;
import ru.sikion.models.validators.Validator;

import java.time.Instant;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implementation of ModuleHandler for Worker Model.
 *
 * @since 1.0
 * @author Sikion
 */
public class WorkerCLIHandler implements ModuleHandler<Worker> {
    /**
     * Method for create fully validated objects by CLI (userMode).
     *
     * @return Built object
     */
    @Override
    public Worker buildObject() throws BuildObjectException {
        try {
            System.out.println("Generating object...");
            Worker result = new Worker();
            System.out.println("Welcome to master of Worker object creation!");
            System.out.println("Follow the instructions to setup your object.");
            System.out.println();

            Scanner scanner = new Scanner(System.in);

            // id
            result.setId(WorkerHandlers.generateID());

            // name
            Validator<String> nameValidator = new NameValidator();
            String name = null;
            do {
                System.out.println("Enter the value of name (Type: String)");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine();
                    if (!line.isEmpty())
                        name = line;
                }
                if (!nameValidator.validate(name)) {
                    System.out.println("Value violates restrictions for field! Try again.");
                    System.out.println("Restrictions: Should be not null and not empty.");
                }
            } while (!nameValidator.validate(name));
            result.setName(name);

            // coords
            System.out.println("Starting coordinates field setup... (Type: Coordinates)");
            CoordinatesCLIHandler coordinatesCLIHandler = new CoordinatesCLIHandler();
            result.setCoordinates(coordinatesCLIHandler.buildObject());

            // from (may null)
            System.out.println("Starting \"from\" field setup... (Type: Location)");
            System.out.print("This field may be skipped to fill. Skip? [y/n] ");
            String answer = scanner.next();
//            if (!answer.equalsIgnoreCase("y")) {
//                LocationCLIHandler locationCLIHandler = new LocationCLIHandler();
//                result.setFrom(locationCLIHandler.buildObject());
//            }
            if (Utilities.hasNextLineOrThrow(scanner)) {
                scanner.nextLine();
            }

            // to (may null)
            System.out.println("Starting \"to\" field setup... (Type: Location)");
            System.out.print("This field may be skipped to fill. Skip? [y/n] ");
            answer = scanner.next();
//            if (!answer.equalsIgnoreCase("y")) {
//                LocationCLIHandler locationCLIHandler = new LocationCLIHandler();
//                result.setTo(locationCLIHandler.buildObject());
//            }
            if (Utilities.hasNextLineOrThrow(scanner)) {
                scanner.nextLine();
            }



            // creationDate
            Date creationDate = Date.from(Instant.now());
            System.out.println("Object created at " + creationDate);
            result.setCreationDate(creationDate);

            System.out.println("Object setup completed! Sending result...");

            return result;

        } catch (StreamInterruptedException e) {
            throw new BuildObjectException("Во время конструирования объекта произошла ошибка: " + e.getMessage());
        }
    }
}
