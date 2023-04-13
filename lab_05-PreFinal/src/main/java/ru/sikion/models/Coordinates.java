package ru.sikion.models;

import java.util.Objects;

/**
 * Model of Coordinates. Sub-model of the Worker. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 *
 * @see Worker
 */
public class Coordinates {
    private Integer x;
    private float y;

    /**
     * Restrictions: The value of this field should be Integer.
     *
     * @return Value of field x
     */
    public Integer getX() {
        return x;
    }

    /**
     * Restrictions: Field cannot be null and the value of this field should be greater than -487.
     *
     * @return Value of field y
     */
    public float getY() {
        return y;
    }

    /**
     * Restrictions: The value of this field should be greater than -107.
     *
     * @param x Value of field x
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Restrictions: Field cannot be null and the value of this field should be greater than -39.
     *
     * @param y Value of field y
     */
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(that.x, x) && that.y == y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
