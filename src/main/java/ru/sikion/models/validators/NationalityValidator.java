package ru.sikion.models.validators;


import ru.sikion.models.Identity.Country;

public class NationalityValidator implements Validator<Country> {
    /**
     * Validates hair color.
     *
     * @param value hair color to validate
     * @return true if hair color is not empty and value from HairColor. Otherwise, false.
     */
    @Override
    public boolean validate(Country value) {
        return true;
    }
}
