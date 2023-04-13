package ru.sikion.models.validators;


import ru.sikion.models.Identity.Status;

/**
 * Status validator. Checks if status is correct.
 *
 * @author Sikion
 * @version 1.0
 */
public class StatusValidator implements Validator<Status> {
    /**
     * Validates status.
     *
     * @param value status to validate
     * @return true if instance of Status, can be null. Otherwise, false.
     */
    @Override
    public boolean validate(Status value) {
        return true;
    }
}
