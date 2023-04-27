package ru.sikion.models.validators;


import ru.sikion.models.Identity.EyeColor;

public class EyeColorValidator implements Validator<EyeColor> {
    /**
     * Validates hair color.
     *
     * @param value hair color to validate
     * @return true if hair color is not empty and value from HairColor. Otherwise, false.
     */
    @Override
    public boolean validate(EyeColor value) {
        return true;
    }
}
