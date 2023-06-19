package server.managers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Класс {@code PasswordManager} содержит статические методы для работы с паролями.
 */
public class PasswordManager {

    /**
     * Получает хэш-последовательность для переданной строки, согласно указанному алгоритму (соль не добавляется).
     * @param nudeString строка, для которой необходимо получить хэш.
     * @param algorithm алгоритм хэширования.
     * @return хэш-последовательность.
     * @throws NoSuchAlgorithmException если алгоритм не найден.
     */
    public static String getHash(String nudeString, String algorithm) throws NoSuchAlgorithmException {
            MessageDigest mDigest = MessageDigest.getInstance(algorithm);
            byte[] hash = mDigest.digest(nudeString.getBytes());
            StringBuilder strongPassword = new StringBuilder();
            for (byte b : hash) strongPassword.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            System.out.println("Получена hash-последовательность.");
            return strongPassword.toString();
    }
}
