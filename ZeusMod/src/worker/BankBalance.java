package worker;

import java.util.Scanner;

/**
 * {@code BankBalance} Объекты класса инкапсулируют сумму денег (double) на банковском счете владельца.
 * Унаследовано от {@link AbstractBalance}.
 * @author SiKion
 * @version 2.0
 * @since 20.12.18
 */
public class BankBalance extends AbstractBalance {

    public BankBalance(double sum){
        super(sum);
    }

    @Override
    public String toString() {
        return "BankBalance{" +
                "sum=" + super.toString() + '}';
    }

    public static BankBalance request(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму денег на счете");
        return new BankBalance(scanner.nextDouble());
    }
}