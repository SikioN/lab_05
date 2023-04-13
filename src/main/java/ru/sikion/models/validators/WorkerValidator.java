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

        if (idValidate.validate(worker.getId()) && new NameValidator().validate(worker.getName())) {
            new CoordXValidator().validate(Optional.of(worker).map(Worker::getCoordinates).map(Coordinates::getX).orElse(0d));
        }
        return false;
    }
}
