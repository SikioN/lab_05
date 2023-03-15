package ru.sikion.models.validators;

/**
 * End date validator. Checks if end date is not null.
 * @version 1.0
 * @author Sikion
 */
public class EndDateValidator implements Validator{
    /**
     * Validates end date.
     * @param value end date to validate
     * @return true if end date is not null. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        return value instanceof java.time.ZonedDateTime endDate;
    }
}
