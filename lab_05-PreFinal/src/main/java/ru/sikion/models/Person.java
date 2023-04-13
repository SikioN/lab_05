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
 * @since 1.0
 */

public class Person {
    private EyeColor eyeColor;
    private HairColor hairColor;
    private Country nationality;


    /**
     * Restrictions: Field can be null.
     *
     * @return Eye color of the worker
     */
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return Hair color of the worker
     */
    public HairColor getHairColor() {
        return hairColor;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return Nationality of the worker
     */
    public Country getNationality() {
        return nationality;
    }


    /**
     * Restrictions: Field can be null.
     *
     * @param eyeColor eye color value to set
     */
    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param hairColor hair color value to set
     */
    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param nationality value to set
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
        return "Person{" +
                "eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }
}
