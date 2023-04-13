package ru.sikion.models.validators;

/**
 * Name validator. Checks if name is not empty.
 * @version 1.0
 * @author Sikion
 */

public class NameValidator implements Validator<String>{
    /**
     * Validates name.
     * @param value name to validate
     * @return true if name is not empty. Otherwise, false.
     */
    @Override
    public boolean validate(String value) {
        return (value != null && !(value.isEmpty() || value.isBlank()));
    }
}
