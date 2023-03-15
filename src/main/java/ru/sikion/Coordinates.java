package ru.sikion;

import java.util.Objects;

/** Model Coordinates. Sub-model of Worker. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 */

public class Coordinates {
    private Long x;
    private Float y;

    /**
     * Restrictions: Field cannot be null.
     * @return Value of field x
     */
    public Long getX() {
        return x;
    }

    /**
     * Restrictions: Field cannot be null.
     * @param x Value of field x
     */
    public void setX(Long x) {
        this.x = x;
    }

    /**
     * Restrictions: Value of this field should be greater than -487.
     * @return Value of field y
     */
    public Float getY() {
        return y;
    }

    /**
     * Restrictions: Value of this field should be greater than -487.
     * @param y Value of field y
     */
    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates that)) return false;
        return Objects.equals(getX(), that.getX()) && Objects.equals(getY(), that.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
