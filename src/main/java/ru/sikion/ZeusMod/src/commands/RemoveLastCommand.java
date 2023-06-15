package ru.sikion.ZeusMod.src.commands;

import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.tale.Shorty;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Класс {@code RemoveLastCommand} переопределяет метод {@code execute ()} для удаления
 * последнего элемента из {@code Collection <? extends Shorty> col}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class RemoveLastCommand extends AbstractCommand {

    public RemoveLastCommand(CollectionManager manager) {
        super(manager);
        setDescription("Удалить последний элемент в коллекции.");
    }

    @Override
    public synchronized String execute() {
        List<Shorty> collection = getManager().getCitizens();
        try {
            collection.remove(collection.size() - 1);
            getManager().save();
            return "Последний элемент в коллекции удалён.";
        }
        catch (NoSuchElementException ex) {
            return "Вы не можете удалить элемент, так как коллекция пуста.";
        }
    }
}