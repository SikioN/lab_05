package ru.sikion.models;

import ru.sikion.models.Identity.Status;

import java.util.Objects;

/**
 * Model of Worker. Main model of the program. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 *
 * @author Sikion
 * @since 1.0
 */
public class Worker implements Comparable<Worker> {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Double salary;
    private java.util.Date startDate;
    private java.time.ZonedDateTime endDate;
    private Status status;
    private Person person;

    /**
     * Restrictions: Field cannot be null. The value of this field should be unique, greater than 0 and automatically generated.
     *
     * @return id of the worker
     */
    public Integer getId() {
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

    /**
     * Restrictions: Field cannot be null.
     *
     * @return Start date of the worker
     */
    public java.util.Date getStartDate() {
        return startDate;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return End date of the worker
     */
    public java.time.ZonedDateTime getEndDate() {
        return endDate;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return Status of the worker
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return Person of the worker
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Restrictions: Field cannot be null. The value of this field should be unique, greater than 0 and automatically generated.
     *
     * @param id value of field id
     */
    public void setId(Integer id) {
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

    /**
     * Restrictions: Field cannot be null.
     *
     * @param startDate of value field startDate
     */
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param endDate of value field endDate
     */
    public void setEndDate(java.time.ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param status of value field status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param person of value field person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(getId(), worker.getId()) && Objects.equals(getName(), worker.getName()) && Objects.equals(getCoordinates(), worker.getCoordinates()) && Objects.equals(getCreationDate(), worker.getCreationDate()) && Objects.equals(getSalary(), worker.getSalary()) && Objects.equals(getStartDate(), worker.getStartDate()) && Objects.equals(getEndDate(), worker.getEndDate()) && getStatus() == worker.getStatus() && Objects.equals(getPerson(), worker.getPerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCoordinates(), getCreationDate(), getSalary(), getStartDate(), getEndDate(), getStatus(), getPerson());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", person=" + person +
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        return 0;
    }

    public Coordinates getCoordinates(Worker worker) {
        return this.coordinates;
    }


//    @Override
//    public int compareTo(Worker o) {
//        if (o == null) return 1;
//        if (o.id == null) return -1;
//        if (this.distance - o.distance < 0)
//            return -1;
//        else if (this.distance == o.distance)
//            return 0;
//        else
//            return 1;
//    }
}
