import java.io.*;
import java.util.Scanner;

class Commander {

    private Scanner fromKeyboard;
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    Commander(Scanner fromKeyboard, ObjectOutputStream toServer, ObjectInputStream fromServer) {
        this.fromKeyboard = fromKeyboard;
        this.toServer = toServer;
        this.fromServer = fromServer;
    }

    /**
     * Парсит пользовательские команды и осуществляет обмен данными с сервером.
     * @throws IOException при отправке и получении данных с сервера.
     */
    void interactiveMode() throws IOException {
        try {
            System.out.println((String) fromServer.readObject()); //Приглашение ввода от сервера
            String command;
            while (true) {
                command = fromKeyboard.nextLine();
                String[] parsedCommand = command.trim().split(" ");
                try {
                    switch (parsedCommand[0]) {
                        case "":
                            break;
                        case "login":
                            login(parsedCommand[1]);
                            break;
                        case "register":
                            register(parsedCommand[1]);
                            break;
                        case "import":
                            importingFile(parsedCommand[1]);
                            break;
                        case "exit":
                            System.exit(0);
                            break;
                        default:
                            toServer.writeObject(command);
                            String answer = (String) fromServer.readObject();
                            if (answer.equals("request add")){
                                String arg = Requestor.requestShorty();
                                toServer.writeObject(command + " " + arg);
                                answer = (String) fromServer.readObject();
                        }
                            System.out.println(answer);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                     System.err.println("Отсутствует аргумент.");
                }
            }
        } catch (ClassNotFoundException e) {
            /* никогда не выбросит, так как используется String, но java требует явную обработку или указание
            в сигнатуре метода, так как это проверяемое исключение */
            System.err.println("Класс не найден: " + e.getMessage());
        }
    }

    /**
     * Импортирует локальный файл и отправляет на сервер.
     * @param path путь к файлу.
     * @throws SecurityException если отсутствуют права rw.
     * @throws IOException если файл не существует.
     */
    private void importingFile(String path) throws ClassNotFoundException {
        File localCollection = new File(path);
        String fileExtension = localCollection.getAbsolutePath().substring(localCollection.getAbsolutePath().lastIndexOf(".") + 1);
        try {
            if (!localCollection.exists() | localCollection.length() == 0  | !fileExtension.equals("json"))
                throw new FileNotFoundException();
            if (!localCollection.canRead()) throw new SecurityException();
            try (BufferedReader inputStreamReader = new BufferedReader(new FileReader(localCollection))) {
                String nextLine;
                StringBuilder result = new StringBuilder();
                while ((nextLine = inputStreamReader.readLine()) != null) result.append(nextLine);
                toServer.writeObject("import " + result.toString());
                System.out.println((String) fromServer.readObject());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл по указанному пути не найден.");
        } catch (SecurityException e) {
            System.err.println("Файл защищён от чтения.");
        } catch (IOException e) {
            System.err.println("Что-то не так с файлом.");
        }
    }

    private void login(String email) throws IOException, ClassNotFoundException {
        System.out.println("Введите пароль:");
        String password = new String(fromKeyboard.nextLine());
        toServer.writeObject("login " + email + " " + password);
        System.out.println((String) fromServer.readObject());
    }

    private void register(String email) throws IOException, ClassNotFoundException {
        System.out.println("Введите пароль:");
        String password = new String(fromKeyboard.nextLine());
        toServer.writeObject("register " + email + " " + password);
        System.out.println((String) fromServer.readObject());
    }
}
