import java.util.Scanner;

/**
 * Класс для запроса элемента коллекции из терминала на клиенте.
 */
public class Requestor {

    public static String requestShorty(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        String shorty = String.format("{\"name\":\"%s\",\"cash\":%s,\"position\":%s,\"birthDate\":%s}", name, requestWalletBalance(), requestCoordinates(), requestDate());
        return shorty;
    }

    public static String requestDate(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату рождения:");

        System.out.println("Введите день:");
        String day = scanner.nextLine();

        System.out.println("Введите меясц:");
        String month = scanner.nextLine();

        System.out.println("Введите год:");
        String year = scanner.nextLine();

        String date = String.format("{\"year\":%s,\"month\":%s,\"day\":%s}", year, month, day);
        return date;
    }

    public static String requestWalletBalance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите баланс:");

        System.out.println("Введите количество фертингов:");
        double sum = scanner.nextDouble();

        System.out.println("Введите количество акций:");
        int amount = scanner.nextInt();

        String balance = String.format("{\"sum\":%s,\"amount\":%s}", sum, amount);
        return balance;

    }

    public static String requestCoordinates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты:");

        System.out.println("Введите x:");
        double x = scanner.nextDouble();

        System.out.println("Введите y:");
        double y = scanner.nextDouble();

        String coordinates = String.format("{\"x\":%s,\"y\":%s}", x, y);
        return coordinates;
    }

}
