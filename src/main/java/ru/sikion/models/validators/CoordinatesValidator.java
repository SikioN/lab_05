package ru.sikion.models.validators;
import ru.sikion.Coordinates;

/**
 * Coordinates validator. Checks if coordinates is not null.
 * @version 1.0
 * @author Sikion
 */
public class CoordinatesValidator implements Validator{
    /**
     * Validates coordinates.
     * @param value coordinates to validate
     * @return true if coordinates is not null. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        if (value instanceof Coordinates coordinates) {
            return coordinates.getX() != null && coordinates.getY() != null;
        }
        return false;
    }
}
