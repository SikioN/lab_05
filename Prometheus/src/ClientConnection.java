import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс {@code ClientConnection} представляет объект клиента, подключаемый к серверу для манипулирования коллекцией.
 */
class ClientConnection {

    private Commander commands;
    private static ClientConnection instance;

    public static ClientConnection getInstance() {
        if (instance == null) {
            instance = new ClientConnection();
        }
        return instance;
    }

    /**
     * Устанавливает активное соединение с сервером.
     */
    void start(int port) {
        Scanner console = new Scanner(System.in);
            while (true) {
                try (Socket outcoming = new Socket("localhost", port)) {
                    outcoming.setSoTimeout(1000);
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(outcoming.getOutputStream());
                         ObjectInputStream inputStream = new ObjectInputStream(outcoming.getInputStream())) {
                        commands = new Commander(console, outputStream, inputStream);
                        commands.interactiveMode();
                        System.out.println("Завершение программы.");
                    }
                } catch (IOException e) {
                    System.err.println("Нет связи с сервером. Подключиться ещё раз ({да} или {нет})?");
                    String answer;
                    while (!(answer = console.nextLine()).equals("да")) {
                        switch (answer) {
                            case "":
                                break;
                            case "нет":
                                System.exit(0);
                                break;
                            default: System.out.println("Введите корректный ответ.");
                        }
                    }
                    System.out.print("Подключение ...");
                    continue;
                }
            }
        }
    }