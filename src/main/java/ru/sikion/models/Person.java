package ru.sikion.models;

import ru.sikion.models.Identity.Country;
import ru.sikion.models.Identity.EyeColor;
import ru.sikion.models.Identity.HairColor;

import java.util.Objects;

/**
 * Model of Person. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 *
 * @author Sikion
 * @version 1.0
 * @since 1.1
 */

public class Person {
    private EyeColor eyeColor;
    private HairColor hairColor;
    private Country nationality;

    /**
     * Restrictions: Field cannot be null.
     *
     * @return eyeColor of the person
     */
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return hairColor of the person
     */
    public HairColor getHairColor() {
        return hairColor;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return nationality of the person
     */
    public Country getNationality() {
        return nationality;
    }


    /**
     * Restrictions: Field cannot be null.
     *
     * @param eyeColor of the person
     */
    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param hairColor of the person
     */
    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param nationality
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getEyeColor() == person.getEyeColor() && getHairColor() == person.getHairColor() && getNationality() == person.getNationality();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEyeColor(), getHairColor(), getNationality());
    }

    @Override
    public String toString() {
        return "Person {" +
                "eye color is " + eyeColor.toString().toLowerCase() +
                ", hair color is " + hairColor.toString().toLowerCase() +
                ", nationality is " + nationality.toString().substring(0, 1).toUpperCase()
                + nationality.toString().substring(1).toLowerCase() +
                '}';
    }
}
