package ru.sikion.models.validators;


/** Base validator. You should implement it for use in handlers.
 *
 * @version 1.0
 * @author Sikion
 */

@FunctionalInterface
public interface Validator {
    /**
     * Provides validation method.
     *
     * @param value value to validate
     * @return true if value is validate. Otherwise false.
     */
    boolean validate(Object value);
}
