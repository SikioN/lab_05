package ru.sikion.models.handlers.userMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.exceptions.StreamInterruptedException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Identity.EyeColor;
import ru.sikion.models.Identity.HairColor;
import ru.sikion.models.Worker;
import ru.sikion.models.handlers.*;
import ru.sikion.models.validators.*;

import java.time.Instant;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
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

            // salary
            Validator<Double> salaryValidator = new SalaryValidator();
            String salary = null;
            Double ssalary = 0.0;
            do {
                System.out.println("Enter the value of salary (Type: Double)");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine();
                    if (!line.isEmpty())
                        salary = line;
                }
                try {
                    if (!salaryValidator.validate(Double.parseDouble(salary))) {
                        System.out.println("Value violates restrictions for field! Try again.");
                        System.out.println("Restrictions: Should be Double and greater than 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Value violates restrictions for field! Try again.");
                    System.out.println("Restrictions: Should be Double and greater than 0.");
                }
                try {
                    if (salaryValidator.validate(Double.parseDouble(salary))) {ssalary = Double.parseDouble(salary); break;}
                } catch (NumberFormatException e) {
                    continue;
                }
            } while (true);
            result.setSalary(ssalary);


            // eyeColor
            Validator<EyeColor> eyeColorValidator = new EyeColorValidator();
            String eyeColor = null;
            EyeColor eyeColor1;
            do {
                System.out.println("Enter the value of eye color (Type: EyeColor)");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine();
                    if (!line.isEmpty())
                        eyeColor = line;
                }
                try {
                    if (!eyeColorValidator.validate(EyeColor.fromString(eyeColor))) {
                        System.out.println("Value violates restrictions for field! Try again.");
                        System.out.println("Restrictions: Should be EyeColor and non nune.");
                    }
                } catch (Exception e) {
                    System.out.println("Value violates restrictions for field! Try again.");
                    System.out.println("Restrictions: Should be EyeColor and non nune.");
                }
                try {
                    if (eyeColorValidator.validate(EyeColor.fromString(eyeColor))) {eyeColor1 = EyeColor.fromString(eyeColor); break;}
                } catch (NumberFormatException e) {
                    continue;
                }
            } while (true);
            result.setEyeColor(eyeColor1);


            // hairColor
            Validator<HairColor> hairColorValidator = new HairColorValidator();
            String hairColor = null;
            HairColor hairColor1;
            do {
                System.out.println("Enter the value of hair color (Type: HairColor)");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().toLowerCase(Locale.ROOT);
                    if (!line.isEmpty())
                        eyeColor = line;
                }
                try {
                    if (!hairColorValidator.validate(HairColor.fromString(hairColor))) {
                        System.out.println("Value violates restrictions for field! Try again.");
                        System.out.println("Restrictions: Should be HairColor and non nune.");
                    }
                } catch (Exception e) {
                    System.out.println("Value violates restrictions for field! Try again.");
                    System.out.println("Restrictions: Should be EyeColor and non nune.");
                }
                try {
                    if (hairColorValidator.validate(HairColor.fromString(hairColor))) {hairColor1 = HairColor.fromString(hairColor); break;}
                } catch (NumberFormatException e) {
                    continue;
                }
            } while (true);
            result.setHairColor(hairColor1);

            // coords
            System.out.println("Starting coordinates field setup... (Type: Coordinates)");
            CoordinatesCLIHandler coordinatesCLIHandler = new CoordinatesCLIHandler();
            result.setCoordinates(coordinatesCLIHandler.buildObject());

            // from (may null)
            System.out.println("Starting \"from\" field setup... (Type: Location)");
            System.out.print("This field may be skipped to fill. Skip? [y/n] ");
            String answer = scanner.next();
            if (Utilities.hasNextLineOrThrow(scanner)) {
                scanner.nextLine();
            }

            // to (may null)
            System.out.println("Starting \"to\" field setup... (Type: Location)");
            System.out.print("This field may be skipped to fill. Skip? [y/n] ");
            answer = scanner.next();

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
            throw new BuildObjectException("An error occurred while designing the object: " + e.getMessage());
        }
    }
}
