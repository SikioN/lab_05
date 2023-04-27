package ru.sikion.models;

import ru.sikion.models.Identity.Country;
import ru.sikion.models.Identity.EyeColor;
import ru.sikion.models.Identity.HairColor;
import ru.sikion.models.Identity.Status;

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
    private java.util.Date startDate;
    private java.time.LocalDate endDate;
    private Status status;
    private Country nationality;
    private EyeColor eyeColor;
    private HairColor hairColor;

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
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return nationality of worker
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return color of hair
     */
    public HairColor getHairColor() {
        return hairColor;
    }
    /**
     * Restrictions: Field can be null.
     *
     * @return Color of eye
     */
    public EyeColor getEyeColor() {
        return eyeColor;
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
    public void setEndDate(java.time.LocalDate endDate) {
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
     * @param nationality of value field Country
     */
    public void setCountry(Country nationality) {
        this.nationality = nationality;
    }


    /**
     * Restrictions: Field can be null.
     *
     * @param hairColor of value field hair color
     */
    public void setCountry(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param eyeColor of value field eye color
     */
    public void setCountry(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }


    /**
     * Restrictions: Field cannot be null. The value of this field should be automatically generated.
     *
     * @param creationDate of value field creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEyeColor(EyeColor eyeColor) {this.eyeColor = eyeColor;}
    public void setHairColor(HairColor hairColor) {this.hairColor = hairColor;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(getId(), worker.getId()) && Objects.equals(getName(), worker.getName()) && Objects.equals(getCoordinates(), worker.getCoordinates()) && Objects.equals(getCreationDate(), worker.getCreationDate()) && Objects.equals(getSalary(), worker.getSalary()) && Objects.equals(getStartDate(), worker.getStartDate()) && Objects.equals(getEndDate(), worker.getEndDate()) && getStatus() == worker.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCoordinates(), getCreationDate(), getSalary(), getStartDate(), getEndDate(), getStatus());
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
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        return 0;
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
