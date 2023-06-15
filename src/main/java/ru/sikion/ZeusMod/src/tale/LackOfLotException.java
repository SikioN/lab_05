package ru.sikion.ZeusMod.src.tale;

/**
 * {@code LackOfLotException} Ошибки, вызванные отсутствием ценных ресурсов, вовлеченных в операцию.
 * @author SiKion
 * @version 2.0
 * @since 20SiKion
 */
public class LackOfLotException extends RuntimeException{

    public LackOfLotException(double sum){
        super("Не хватает фертингов для совершения операции, " + sum);
    }

    public LackOfLotException(int amount){
        super("Не хватает акций для совершения операции, " + amount);
    }
}