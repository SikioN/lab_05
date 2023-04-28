package ru.sikion.models;

import ru.sikion.models.Identity.Status;
import ru.sikion.models.Utilites.CodeColor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Model of Worker. Main model of the program. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 *
 * @author Sikion
 * @since 1.0
 */
public class Worker implements Comparable<Worker> {
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Double salary;
//    private java.util.Date startDate;
//    private java.time.LocalDate endDate;
    private String status;
    private Person person;

    /**
     * Restrictions: Field cannot be null. The value of this field should be unique, greater than 0 and automatically generated.
     *
     * @return id of the worker
     */
    public int getId() {
        return id;
    }

    /**
     * Restrictions: Field cannot be null. String must not be empty.
     *
     * @return Name of the worker
     */
    public String getName() {
        return name;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return Coordinates of the worker
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Restrictions: Field cannot be null and the value of this field should be automatically generated.
     *
     * @return Creation date of the worker
     */
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    /**
     * Restrictions: Field can be null. Value of this field should be greater than 0.
     *
     * @return Salary of the worker
     */
    public Double getSalary() {
        return salary;
    }

//    /**
//     * Restrictions: Field cannot be null.
//     *
//     * @return Start date of the worker
//     */
//    public java.util.Date getStartDate() {
//        return startDate;
//    }

    /**
     * Restrictions: Field can be null.
     *
     * @return End date of the worker
     */
    public Person getPersonality() {
        return person;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return Status of the worker
     */
    public String getStatus() {
        return status;
    }


//    /**
//     * Restrictions: Field can be null.
//     *
//     * @return End date of the worker
//     */
//    public LocalDate getEndDate() {
//        return endDate;
//    }

    /**
     * Restrictions: Field cannot be null. The value of this field should be unique, greater than 0 and automatically generated.
     *
     * @param id value of field id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restrictions: Field cannot be null. String must not be empty.
     *
     * @param name value of field name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param coordinates value of field coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Restrictions: Field can be null. Value of this field should be greater than 0.
     *
     * @param salary of value field salary
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

//    /**
//     * Restrictions: Field cannot be null.
//     *
//     * @param startDate of value field startDate
//     */
//    public void setStartDate(java.util.Date startDate) {
//        this.startDate = startDate;
//    }

//    /**
//     * Restrictions: Field can be null.
//     *
//     * @param endDate of value field endDate
//     */
//    public void setEndDate(java.time.LocalDate endDate) {
//        this.endDate = endDate;
//    }

    /**
     * Restrictions: Field can be null.
     *
     * @param status of value field status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Restrictions: Field cannot be null. The value of this field should be automatically generated.
     *
     * @param creationDate of value field creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    /**
     * Restrictions: Field can be null.
     *
     * @param person of value field person
     */
    public void setPersonality(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(getId(), worker.getId()) && Objects.equals(getName(), worker.getName()) && Objects.equals(getCoordinates(), worker.getCoordinates()) && Objects.equals(getCreationDate(), worker.getCreationDate()) && Objects.equals(getSalary(), worker.getSalary())
//                && Objects.equals(getStartDate(), worker.getStartDate())
//                && Objects.equals(getEndDate(), worker.getEndDate())
                && getStatus() == worker.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCoordinates(), getCreationDate(), getSalary(),
//                getStartDate(), getEndDate(),
                getStatus());
    }


    @Override
    public String toString() {
        return CodeColor.BLUE + "Worker №" + id + CodeColor.NONCOLOR +
                "\n" + CodeColor.VIOLET + "  name" + CodeColor.NONCOLOR + " = " + name +
                "\n" + CodeColor.VIOLET + "  coordinates" + CodeColor.NONCOLOR + " = " + coordinates +
                "\n" + CodeColor.VIOLET + "  creationDate" + CodeColor.NONCOLOR + " = " + creationDate +
                "\n" + CodeColor.VIOLET + "  salary" + CodeColor.NONCOLOR + " = " + salary +
//                "\n" + CodeColor.VIOLET + "  startDate" + CodeColor.NONCOLOR + " = " + startDate +
//                "\n" + CodeColor.VIOLET + "  endDate" + CodeColor.NONCOLOR + " = " + endDate +
                "\n" + CodeColor.VIOLET + "  status" + CodeColor.NONCOLOR + " = " + status +
                "\n" + CodeColor.VIOLET + "  personality" + CodeColor.NONCOLOR + " = " + person +
                "\n";
    }

    @Override
    public int compareTo(Worker o) {
        if (o == null) return 1;
        if (this.getSalary() - o.getSalary() < 0) return -1;
        else if (Objects.equals(this.salary, o.salary)) return 0;
        else return 1;
    }
}
