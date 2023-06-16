package worker;

/**
 * {@code LocationException} Ошибки, возникающие, если объект типа {@link Worker} пытается выполнить действие,
 * запрещённое в этой локации.
 * @author SiKion
 * @version 2.0
 * @since 20.12.18
 */
public class LocationException extends RuntimeException{

    public LocationException(Town.Place space){
        super("Недопустимая локация, " + space);
    }
}