package ru.sikion.models.validators;


import ru.sikion.models.Identity.HairColor;

public class HairColorValidator implements Validator<HairColor> {
    /**
     * Validates hair color.
     *
     * @param value hair color to validate
     * @return true if hair color is not empty and value from HairColor. Otherwise, false.
     */
    @Override
    public boolean validate(HairColor value) {
        return value != null;
    }
}
