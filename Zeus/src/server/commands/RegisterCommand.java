package server.commands;

import server.managers.PasswordManager;
import server.managers.DatabaseManager;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Класс {@code RegisterCommand} переопределяет метод {@code execute()} для осуществления регистрации в БД.
 */
public class RegisterCommand extends AbstractCommand {

    public RegisterCommand() {
        setDescription("Зарегистрироваться в системе. Синтаксис {register email}." +
                "\nПароль будет сгенерирован и отправлен на указанною почту.");
    }

    @Override
    public synchronized String execute(String[] args) {
            String email =  args[0];
            String password = args[1];
            try (Connection connection = DatabaseManager.getInstance().getConnection()) {
                connection.setAutoCommit(false);
                PreparedStatement request = connection.prepareStatement("INSERT INTO users (email, password) " +
                        "SELECT ?, ? WHERE NOT EXISTS (SELECT email FROM users WHERE email = ?)");
                request.setString(1, email.toString());
                try {
                    request.setString(2, PasswordManager.getHash(password, "MD5"));
                } catch (NoSuchAlgorithmException ignored) {
                }
                request.setString(3, email.toString());
                if (request.executeUpdate() == 1) {
                    connection.commit();
                    return "Регистрация завершена.";
                } else return "Указанная почта занята.";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Произошла ошибка на стороне сервера при отправке запроса к БД. Попробуйте ещё раз позже.";
            }
    }
}