package ru.sikion.models.validators;


/**
 * Base validator. You should implement it for use in handlers.
 *
 * @author Sikion
 * @param <T> Type of validation value.
 * @version 1.0
 */

@FunctionalInterface
public interface Validator<T> {
    /**
     * Provides validation method.
     *
     * @param value value to validate
     * @return true if value is validate. Otherwise false.
     */
    boolean validate(T value);
}
