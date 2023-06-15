package ru.sikion.ZeusMod.src.tale;

/**
 * {@code LocationException} Ошибки, возникающие, если объект типа {@link Shorty} пытается выполнить действие,
 * запрещённое в этой локации.
 * @author SiKion
 * @version 2.0
 * @since 20SiKion
 */
public class LocationException extends RuntimeException{

    public LocationException(Town.Place space){
        super("Недопустимая локация, " + space);
    }
}