package ru.sikion.models.validators;

/**
 * Salary validator. Checks if salary is not null and greater than 0.
 * @version 1.0
 * @author Sikion
 */
public class SalaryValidator implements Validator{
    /**
     * Validates salary.
     * @param value salary to validate
     * @return true if salary is not null and greater than 0. Otherwise, false.
     */
    @Override
    public boolean validate(Object value) {
        if (value instanceof Double salary) {
            return salary > 0;
        }
        return false;
    }
}
