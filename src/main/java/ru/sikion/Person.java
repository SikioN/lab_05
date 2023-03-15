package ru.sikion;

import java.util.Objects;

/**
 * Model of Person. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 *
 * @since 1.0
 * @author Sikion
 * */

public class Person {
    private String passportID; //Значение этого поля должно быть уникальным, Длина строки не должна быть больше 36, Поле не может быть null
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null

    /**
     * Restrictions: Field cannot be null. The value of this field should be unique, greater than 0 and lower than 36.
     * @return id of the worker
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Restrictions: Field can be null.
     * @return Eye color of the worker
     */
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    /**
     * Restrictions: Field cannot be null.
     * @return Hair color of the worker
     */
    public HairColor getHairColor() {
        return hairColor;
    }

    /**
     * Restrictions: Field can be null.
     * @return Nationality of the worker
     */
    public Country getNationality(){
        return nationality;
    }

    /**
     * Restrictions: Field cannot be null. The value of this field should be unique, greater than 36.
     * @param passportID id value to set
     */
    public void setPassportID(String passportID){
        this.passportID = passportID;
    }

    /**
     * Restrictions: Field can be null.
     * @param eyeColor eye color value to set
     */
    public void setEyeColor(EyeColor eyeColor){
        this.eyeColor = eyeColor;
    }

    /**
     * Restrictions: Field cannot be null.
     * @param hairColor hair color value to set
     */
    public void setHairColor(HairColor hairColor){
        this.hairColor = hairColor;
    }

    /**
     * Restrictions: Field can be null.
     * @param nationality value to set
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getPassportID(), person.getPassportID()) && getEyeColor() == person.getEyeColor() && getHairColor() == person.getHairColor() && getNationality() == person.getNationality();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassportID(), getEyeColor(), getHairColor(), getNationality());
    }

    @Override
    public String toString() {
        return "Person{" +
                "passportID='" + passportID + '\'' +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }
}
