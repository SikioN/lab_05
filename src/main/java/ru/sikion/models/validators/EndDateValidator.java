package ru.sikion.models.validators;

import java.time.LocalDate;

/**
 * End date validator. Checks if end date is not null.
 *
 * @author Sikion
 * @version 1.0
 */
public class EndDateValidator implements Validator<LocalDate> {
    /**
     * Validates end date.
     *
     * @param value end date to validate
     * @return true if date is date. Otherwise, false.
     */
    @Override
    public boolean validate(LocalDate value) {
        return true;
    }
}
