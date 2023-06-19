package server.managers;

import com.jcraft.jsch.IO;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс {@code DatabaseManager} обеспечивает доступ к базе данных PostgreSQL.studs
 */
public final class DatabaseManager {

    private String DB_URL;
    private String USER;
    private String PASSWORD;
    private static volatile DatabaseManager instance;

    /**
     * Предоставляет доступ к БД. БД должна быть одна на приложение, поэтому реализован singleton шаблон.
     */
    public static DatabaseManager getInstance() {

        DatabaseManager instance2 = instance;
        if (instance2 == null) {
            synchronized (DatabaseManager.class) {
                instance2 = instance;
                if (instance2 == null) instance = new DatabaseManager();
            }
        }
        return instance;
    }

    /**
     * Инициализирует БД и осуществляет пробное подключение к ней.
     */
    private DatabaseManager() {
        try {
            Path path = Paths.get("~/.pgpass");
            Scanner scanner = new Scanner(path);
            PASSWORD = scanner.nextLine().split(":")[4];
            USER = scanner.nextLine().split(":")[3];
        } catch (IOException ignored) {}

        DB_URL = "jdbc:postgresql://pg/studs";
        try (Connection testConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             ResultSet testRequest = testConnection.createStatement().executeQuery("SELECT version()")) {
            System.out.println("Идёт установка связи с БД.");
            while (testRequest.next())
                System.out.println("Связь с БД установлена." + " Версия: " + testRequest.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Возвращает новое соединение с БД.
     * @return объект {@link Connection} для связи.
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * Нужен для удобства при отладке. Если OS == SunOS, значит программа запущена на гелиосе, и загружается
     * helios_db.properties, иначе локальная база данных. По факту, этот метод был бы не нужен, если бы к БД на гелиосе
     * можно было подключаться без SSH тунеля.
     * @return имя подходящено файла .properties.
     */
    @Deprecated
    private String chooseDBProperties() {
        if (System.getProperty("os.name").equals("SunOS")) return "helios_db.properties";
        else return "local_db.properties";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabaseManager)) return false;
        DatabaseManager manager = (DatabaseManager) o;
        return Objects.equals(DB_URL, manager.DB_URL) &&
                Objects.equals(USER, manager.USER) &&
                Objects.equals(PASSWORD, manager.PASSWORD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DB_URL, USER, PASSWORD);
    }

    @Override
    public String toString() {
        return "DatabaseManager{" +
                "DB_URL='" + DB_URL + '\'' +
                ", USER='" + USER + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}