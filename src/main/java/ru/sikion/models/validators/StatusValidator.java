package ru.sikion.models.validators;
import ru.sikion.Status;

/**
 * Status validator. Checks if status is correct.
 * @version 1.0
 * @author Sikion
 */
public class StatusValidator implements Validator{
    /**
     * Validates status.
     * @param value status to validate
     * @return true if status is not empty and value from Status. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        return value instanceof Status status;
    }
}
