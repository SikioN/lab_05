package ru.sikion.models.handlers.userMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.exceptions.StreamInterruptedException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Identity.Status;
import ru.sikion.models.Utilites.CodeColor;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.handlers.WorkerHandlers;
import ru.sikion.models.validators.NameValidator;
import ru.sikion.models.validators.SalaryValidator;
import ru.sikion.models.validators.StatusValidator;
import ru.sikion.models.validators.Validator;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
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
            System.out.println();
            Validator<String> nameValidator = new NameValidator();
            String name = null;
            do {
                System.out.print("Enter the value of name (Type: String): ");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty())
                        name = line;
                }
                if (!nameValidator.validate(name)) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("Restrictions: Should be not null and not empty.\n");
                }
            } while (!nameValidator.validate(name));
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            result.setName(name);

            System.out.println();
            // salary
            Validator<Double> salaryValidator = new SalaryValidator();
            String salary = "";
            double ssalary = 0.0;
            do {
                System.out.print("Enter the value of salary (Type: Double): ");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty())
                        salary = line;
                }
                try {
                    if (!salaryValidator.validate(Double.parseDouble(salary))) {
                        System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                        System.out.println("Restrictions: Should be Double and greater than 0.\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("Restrictions: Should be Double and greater than 0.\n");
                }
                try {
                    if (salaryValidator.validate(Double.parseDouble(salary))) {ssalary = Double.parseDouble(salary); break;}
                } catch (NumberFormatException e) {
                    continue;
                }
            } while (true);
            result.setSalary(ssalary);

            System.out.println();
            // coordinates
            System.out.println("Starting coordinates field setup... (Type: Coordinates)");
            CoordinatesCLIHandler coordinatesCLIHandler = new CoordinatesCLIHandler();
            result.setCoordinates(coordinatesCLIHandler.buildObject());

            System.out.println();
            // personality
            System.out.println("Starting personality field setup... (Type: Personality)");

            while (true) {

                System.out.print("This step may be skipped to fill. Do you want to fill it now? [" + CodeColor.GREEN + "y" + CodeColor.NONCOLOR + "/" + CodeColor.RED + "n" + CodeColor.NONCOLOR + "] ");
                String answer = scanner.next();
                System.out.println();

                if (Objects.equals(answer, "y") || Objects.equals(answer, "yes") || Objects.equals(answer, "1")) {
                    PersonCLIHAndler personCLIHAndler = new PersonCLIHAndler();
                    result.setPersonality(personCLIHAndler.buildObject());
                    break;
                } else if (Objects.equals(answer, "n") || Objects.equals(answer, "no") || Objects.equals(answer, "2")) {
                    System.out.println("Skipped. You can fill it later.");
                    break;
                }
                System.out.println(CodeColor.RED + "\nInvalid answer! Try again.\n" + CodeColor.NONCOLOR);
            }

            System.out.println();
            // status
            System.out.println("Starting status field setup... (Type: Status)");

            while (true) {

                System.out.print("This step may be skipped to fill. Do you want to fill it now? [" + CodeColor.GREEN + "y" + CodeColor.NONCOLOR + "/" + CodeColor.RED + "n" + CodeColor.NONCOLOR + "] ");
                String answer = scanner.next();
                System.out.println();

                if (Objects.equals(answer, "y") || Objects.equals(answer, "yes") || Objects.equals(answer, "1")) {

                    System.out.println(CodeColor.GREEN + "\nAvailable values: " + CodeColor.NONCOLOR);
                    for (Status value : Status.values()) {
                        System.out.println(value);
                    }
                    System.out.println();
                    Validator<Status> statusValidator = new StatusValidator();
                    String status = null;
                    Status status1;

                    do {
                        System.out.print("Enter the value of status (Type: Status):  ");
                        String line = scanner.nextLine().toLowerCase().trim();
                        if (Utilities.hasNextLineOrThrow(scanner)) {
                            if (!line.isEmpty())
                                status = line;
                        }
                        try {
                            if (!statusValidator.validate(Status.fromString(status))) {
                                System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                                System.out.println("Restrictions: Should be Status.\n");
                            }
                        } catch (Exception e) {
                            System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                            System.out.println("Restrictions: Should be Status.\n");
                        }
                        try {
                            if (statusValidator.validate(Status.fromString(status))) {
                                status1 = Status.fromString(status);
                                break;
                            }
                        } catch (Exception e) {
                            continue;
                        }

                        System.out.println("\nAvailable values: ");
                        for (Status value : Status.values()) {
                            System.out.println(value);
                        }

                    } while (true);

                    result.setStatus(status1);
                    break;
                } else if (Objects.equals(answer, "n") || Objects.equals(answer, "no") || Objects.equals(answer, "2")) {
                    System.out.println("Skipped. You can fill it later.");
                    break;
                }
                System.out.println(CodeColor.RED + "\nInvalid answer! Try again.\n" + CodeColor.NONCOLOR);
            }


            // from (may null)
//            System.out.println("Starting \"from\" field setup... (Type: Location)");
//            System.out.print("This field may be skipped to fill. Skip? [y/n] ");
//            String answer = scanner.next();
//            if (Utilities.hasNextLineOrThrow(scanner)) {
//                scanner.nextLine();
//            }
//
//            // to (may null)
//            System.out.println("Starting \"to\" field setup... (Type: Location)");
//            System.out.print("This field may be skipped to fill. Skip? [y/n] ");
//            answer = scanner.next();
//
//            if (Utilities.hasNextLineOrThrow(scanner)) {
//                scanner.nextLine();
//            }

            System.out.println();
            // creationDate
            Date creationDate = Date.from(Instant.now());
            System.out.println("Object created at " + creationDate);
            result.setCreationDate(creationDate);

            System.out.println("Object setup completed! Sending result...");

            return result;

        } catch (StreamInterruptedException e) {
            throw new BuildObjectException("An error occurred while designing the object: " + e.getMessage());
        }
    }
}
