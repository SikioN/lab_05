package ru.sikion.models.handlers.userMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.exceptions.StreamInterruptedException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Coordinates;
import ru.sikion.models.Utilites.CodeColor;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.validators.CoordXValidator;
import ru.sikion.models.validators.CoordYValidator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implementation of ModuleHandler for Coordinates Model.
 *
 * @since 1.0
 * @author Sikion
 */
public class CoordinatesCLIHandler implements ModuleHandler<Coordinates> {

    /**
     * Method for create fully validated objects by CLI.
     *
     * @return Built object
     */
    @Override
    public Coordinates buildObject() throws BuildObjectException {
        try {
            System.out.println("Generating object...");
            Coordinates result = new Coordinates();
            System.out.println("Welcome to master of Coordinates object creation!");
            System.out.println("Follow the instructions to setup your object.");
            System.out.println();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    CoordXValidator xValidator = new CoordXValidator();
                    System.out.print("Enter the value of x (Type: int): ");
                    int value = 0;
                    if (Utilities.hasNextLineOrThrow(scanner)) {
                        String line = scanner.nextLine();
                        if (!line.isEmpty())
                            value = Integer.parseInt(line);
                    }
                    if (xValidator.validate(value))
                        result.setX(value);
                    else {
                        System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again.\n" + CodeColor.NONCOLOR);
                        continue;
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("You should enter a positive real number.\n");
                    continue;
                }
                break;
            }

            System.out.println();
            while (true) {
                try {
                    CoordYValidator yValidator = new CoordYValidator();
                    System.out.print("Enter the value of y (Type: float): ");
                    Float value = null;
                    if (Utilities.hasNextLineOrThrow(scanner)) {
                        String line = scanner.nextLine();
                        if (!line.isEmpty())
                            value = Float.valueOf(line);
                    }
                    if (yValidator.validate(value))
                        result.setY(value);
                    else {
                        System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                        System.out.println("Restrictions: float number. Not null and should be greater than -487.\n");
                        continue;
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("You should enter a real number, matches float value standard (not so big/small).\n");
                    continue;
                }
                break;
            }

            System.out.println("Object setup completed! Sending result...");

            return result;
        } catch (StreamInterruptedException e) {
            throw new BuildObjectException("An error occurred while designing the object: " + e.getMessage());
        }
    }
}
