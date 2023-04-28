package ru.sikion.models.handlers.userMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Identity.EyeColor;
import ru.sikion.models.Identity.HairColor;
import ru.sikion.models.Person;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.validators.EyeColorValidator;
import ru.sikion.models.validators.HairColorValidator;
import ru.sikion.models.validators.Validator;

import java.util.Scanner;

/**
 * Implementation of ModuleHandler for Coordinates Model.
 *
 * @since 1.0
 */

public class PersonCLIHAndler implements ModuleHandler<PersonCLIHAndler> {

    /**
     * Method for create fully validated objects by CLI.
     *
     * @return Built object
     */
    @Override
    public PersonCLIHAndler buildObject() throws BuildObjectException {
        try {
            System.out.println("Generating object...");
            Person result = new Person();
            System.out.println("Welcome to master of Person object creation!");
            System.out.println("Follow the instructions to setup your personality.");
            System.out.println();

            Scanner scanner = new Scanner(System.in);

            // eyeColor
            Validator<EyeColor> eyeColorValidator = new EyeColorValidator();
            String eyeColor = null;
            EyeColor eyeColor1;
            do {
                System.out.println("Enter the value of eye color (Type: EyeColor)");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().toLowerCase();
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
                } catch (Exception e) {
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
                    String line = scanner.nextLine().toLowerCase();
                    if (!line.isEmpty())
                        hairColor = line;
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
                } catch (Exception e) {
                    continue;
                }
            } while (true);
            result.setHairColor(hairColor1);
        } catch (Exception e) {
            throw new BuildObjectException("Error while building object!");
        }

        return null;
    }
}

