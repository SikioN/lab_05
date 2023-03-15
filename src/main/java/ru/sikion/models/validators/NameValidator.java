package ru.sikion.models.validators;

/**
 * Name validator. Checks if name is not empty.
 * @version 1.0
 * @author Sikion
 */

public class NameValidator implements Validator{
    /**
     * Validates name.
     * @param value name to validate
     * @return true if name is not empty. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        if (value instanceof String name) {
            return name.trim().length() > 0;
        }
        return false;
    }
}
