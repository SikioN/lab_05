package ru.sikion.models.validators;

import java.util.Date;

/**
 * Start date validator. Checks if start instance of Date.
 *
 * @author Sikion
 * @version 1.0
 */
public class StartDateValidator implements Validator<Date> {
    /**
     * Validates start date.
     *
     * @param value start date to validate
     * @return true if instance of Date. Otherwise, false.
     */
    @Override
    public boolean validate(Date value) {
        return true;
    }
}
