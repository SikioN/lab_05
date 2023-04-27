package ru.sikion.models.validators;

import ru.sikion.models.Coordinates;
import ru.sikion.models.Worker;

import java.util.Optional;

/**
 * Implementation of validator for name field. (Worker)
 * *
 * * @since 1.1
 * * @author Sikion
 */
public class WorkerValidator implements Validator<Worker> {
    @Override
    public boolean validate(Worker worker) {
        Validator<Integer> idValidate = (id) -> id != null && id > 0;

        return idValidate.validate(Math.toIntExact(worker.getId())) &&
                new NameValidator().validate(worker.getName()) &&
                new SalaryValidator().validate(worker.getSalary()) &&
                new StartDateValidator().validate(worker.getStartDate()) &&
                new EndDateValidator().validate(worker.getEndDate()) &&
                new StatusValidator().validate(worker.getStatus());
    }
}
