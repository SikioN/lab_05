package ru.sikion.models.validators;

import ru.sikion.HairColor;

public class HairColorValidator implements Validator{
    /**
     * Validates hair color.
     * @param value hair color to validate
     * @return true if hair color is not empty and value from HairColor. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        return value instanceof HairColor hairColor;
    }
}
