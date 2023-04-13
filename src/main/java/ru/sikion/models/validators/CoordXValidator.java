package ru.sikion.models.validators;

/**
 * Coordinates validator. Checks if coordinates is not null.
 *
 * @author Sikion
 * @version 1.0
 */
public class CoordXValidator implements Validator<Integer> {
    /**
     * Validates coordinates.
     *
     * @param value coordinates to validate
     * @return true if coordinates is not null. Otherwise, false.
     */
    @Override
    public boolean validate(Integer value) {
        return value != null;
    }
}
