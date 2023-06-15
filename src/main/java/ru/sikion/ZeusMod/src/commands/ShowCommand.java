package ru.sikion.ZeusMod.src.commands;

import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.tale.Shorty;
import java.util.List;

/**
 * Класс {@code ShowCommand} переопределяет метод {@code execute ()} для отображения
 * всех элементов из {@code Collection <? extends Shorty> col}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class ShowCommand extends AbstractCommand {

    public ShowCommand(CollectionManager manager) {
        super(manager);
        setDescription("Выводит все элементы коллекции.");
    }

    @Override
    public synchronized String execute() {
        List<Shorty> collection = getManager().getCitizens();
        StringBuilder result = new StringBuilder();
        if (collection.size() != 0) {
            for (Shorty s: collection) {
                result.append(getManager().getSerializer().toJson(s)).append("\n    ");
            }
            return result.toString();
        }
        else return "Коллекция пуста.";
    }
}