package ru.sikion.models.validators;


import ru.sikion.models.Identity.Country;
import ru.sikion.models.Identity.EyeColor;

public class NationalityValidator implements Validator<Country> {
    /**
     * Validates hair color.
     *
     * @param value hair color to validate
     * @return true if value from Country and can be null. Otherwise, false.
     */
    @Override
    public boolean validate(Country value) {
        return true;
    }
}
