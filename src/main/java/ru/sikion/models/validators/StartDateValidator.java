package ru.sikion.models.validators;

/**
 * Start date validator. Checks if start instance of Date.
 * @version 1.0
 * @author Sikion
 */
public class StartDateValidator implements Validator {
    /**
     * Validates start date.
     * @param value start date to validate
     * @return true if instance of Date. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        return value instanceof java.util.Date startDate;
    }
}
