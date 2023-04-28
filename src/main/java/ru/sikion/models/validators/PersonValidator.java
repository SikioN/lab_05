package ru.sikion.models.validators;

import ru.sikion.models.Coordinates;
import ru.sikion.models.Person;
import ru.sikion.models.Worker;

import java.util.Optional;

/**
 * Implementation of validator for name field. (Worker)
 * *
 * * @since 1.1
 * * @author Sikion
 */
public class PersonValidator implements Validator<Person> {
    @Override
    public boolean validate(Person person) {
        return new HairColorValidator().validate(person.getHairColor()) &&
                new EyeColorValidator().validate(person.getEyeColor()) &&
                new NationalityValidator().validate(person.getNationality());
    }
}
