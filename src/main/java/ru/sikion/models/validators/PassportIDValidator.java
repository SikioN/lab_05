package ru.sikion.models.validators;

/**
 * Passport ID validator. Checks if passport ID is not empty.
 * @version 1.0
 * @author Sikion
 */
public class PassportIDValidator implements Validator{
    /**
     * Validates passport ID.
     * @param value passport ID to validate
     * @return true if passport ID is unique, greater than 0 and lower than 36. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        if (value instanceof String passportID) {
            return passportID.trim().length() > 0 && passportID.trim().length() < 36;
        }
        return false;
    }

}
