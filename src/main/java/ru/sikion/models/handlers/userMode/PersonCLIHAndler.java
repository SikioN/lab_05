package ru.sikion.models.handlers.userMode;

import ru.sikion.exceptions.BuildObjectException;
import ru.sikion.main.Utilities;
import ru.sikion.models.Identity.Country;
import ru.sikion.models.Identity.EyeColor;
import ru.sikion.models.Identity.HairColor;
import ru.sikion.models.Person;
import ru.sikion.models.Utilites.CodeColor;
import ru.sikion.models.handlers.ModuleHandler;
import ru.sikion.models.validators.EyeColorValidator;
import ru.sikion.models.validators.HairColorValidator;
import ru.sikion.models.validators.NationalityValidator;
import ru.sikion.models.validators.Validator;

import java.util.Scanner;

/**
 * Implementation of ModuleHandler for Coordinates Model.
 *
 * @since 1.0
 */

public class PersonCLIHAndler implements ModuleHandler<Person> {

    /**
     * Method for create fully validated objects by CLI.
     *
     * @return Built object
     */
    @Override
    public Person buildObject() throws BuildObjectException {
        try {
            System.out.println("Generating identity for worker...");
            Person result = new Person();
            System.out.println("Welcome to master of Person object creation!");
            System.out.println("Follow the instructions to setup your personality.");

            Scanner scanner = new Scanner(System.in);

            System.out.println();
            // eyeColor
            Validator<EyeColor> eyeColorValidator = new EyeColorValidator();
            String eyeColor = null;
            EyeColor eyeColor1;
            do {
                System.out.print("Enter the value of eye color (Type: EyeColor): ");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().toLowerCase().trim();
                    if (!line.isEmpty())
                        eyeColor = line;
                }
                try {
                    if (!eyeColorValidator.validate(EyeColor.fromString(eyeColor))) {
                        System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                        System.out.println("Restrictions: Should be Color.\n");
                    }
                } catch (Exception e) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("Restrictions: Should be EyeColor and non nune.\n");
                }
                try {
                    if (eyeColorValidator.validate(EyeColor.fromString(eyeColor))) {eyeColor1 = EyeColor.fromString(eyeColor); break;}
                } catch (Exception e) {
                    continue;
                }
            } while (true);
            result.setEyeColor(eyeColor1);

            System.out.println();
            // hairColor
            Validator<HairColor> hairColorValidator = new HairColorValidator();
            String hairColor = null;
            HairColor hairColor1;
            do {
                System.out.print("Enter the value of hair color (Type: HairColor): ");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().toLowerCase().trim();
                    if (!line.isEmpty())
                        hairColor = line;
                }
                try {
                    if (!hairColorValidator.validate(HairColor.fromString(hairColor))) {
                        System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                        System.out.println("Restrictions: Should be Color.\n");
                    }
                } catch (Exception e) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("Restrictions: Should be EyeColor and non nune.\n");
                }
                try {
                    if (hairColorValidator.validate(HairColor.fromString(hairColor))) {
                        hairColor1 = HairColor.fromString(hairColor);
                        break;
                    }
                } catch (Exception e) {
                    continue;
                }
            } while (true);
            result.setHairColor(hairColor1);

            System.out.println();
            // nationality
            Validator<Country> nationalityValidator = new NationalityValidator();
            String nationality = null;
            Country nationality1;
            do {
                System.out.print("Enter the name of the country in which the worker was born (Type: Country): ");
                if (Utilities.hasNextLineOrThrow(scanner)) {
                    String line = scanner.nextLine().toLowerCase().trim();
                    if (!line.isEmpty())
                        nationality = line;
                }
                try {
                    if (!nationalityValidator.validate(Country.fromString(nationality))) {
                        System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                        System.out.println("Restrictions: Should be Country.\n");
                    }
                } catch (Exception e) {
                    System.out.println(CodeColor.RED + "\nValue violates restrictions for field! Try again." + CodeColor.NONCOLOR);
                    System.out.println("Restrictions: Should be Country.\n");
                }
                try {
                    if (nationalityValidator.validate(Country.fromString(nationality))) {
                        nationality1 = Country.fromString(nationality);
                        break;
                    }
                } catch (Exception e) {
                    continue;
                }
            } while (true);
            result.setNationality(nationality1);

            return result;



        } catch (Exception e) {
            throw new BuildObjectException("Error while building object!");
        }

    }
}

