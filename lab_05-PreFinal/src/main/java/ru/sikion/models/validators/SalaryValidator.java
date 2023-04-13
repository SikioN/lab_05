package ru.sikion.models.validators;

/**
 * Salary validator. Checks if salary is not null and greater than 0.
 *
 * @author Sikion
 * @version 1.0
 */
public class SalaryValidator implements Validator<Double> {
    /**
     * Validates salary.
     *
     * @param value salary to validate
     * @return true if salary is not null and greater than 0. Otherwise, false.
     */
    @Override
    public boolean validate(Double value) {
        return (value != null && value > 0);
    }
}
