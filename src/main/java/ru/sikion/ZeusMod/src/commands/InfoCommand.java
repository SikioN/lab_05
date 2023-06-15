package ru.sikion.ZeusMod.src.commands;

import ru.sikion.ZeusMod.src.server.CollectionManager;

/**
 * Класс {@code InfoCommand} переопределяет метод {@code execute ()} для отображения информации о {@link CollectionManager}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class InfoCommand extends AbstractCommand {

    public InfoCommand(CollectionManager manager) {
        super(manager);
        setDescription("Выводит информацию о коллекции.");
    }

    @Override
    public String execute(String arg) {
        return execute();
    }

    @Override
    public synchronized String execute() {
        return "Лабораторная 6 сделана NM – ПР1.3\n" + getManager().toString();
    }
}