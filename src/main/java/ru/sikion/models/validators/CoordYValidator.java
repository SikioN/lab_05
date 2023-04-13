package ru.sikion.models.validators;

/**
 * Coordinates validator. Checks if coordinates is not null.
 *
 * @author Sikion
 * @version 1.0
 */
public class CoordYValidator implements Validator<Float> {
    /**
     * Validates coordinates.
     *
     * @param value coordinates to validate
     * @return true if coordinates greater than -487. Otherwise, false.
     */
    @Override
    public boolean validate(Float value) {
        return value != null && value > -487 && value != Float.POSITIVE_INFINITY;
    }
}
