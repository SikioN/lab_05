package ru.sikion.models.validators;


import ru.sikion.models.Identity.EyeColor;

public class EyeColorValidator implements Validator<EyeColor> {
    /**
     * Validates hair color.
     *
     * @param value eye color to validate
     * @return true if value from HairColor and can be null. Otherwise, false.
     */
    @Override
    public boolean validate(EyeColor value) {
        return true;
    }
}
