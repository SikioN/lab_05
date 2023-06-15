package ru.sikion.ZeusMod.src.commands;

import com.google.gson.JsonSyntaxException;
import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.tale.Shorty;
import java.util.List;

/**
* Класс {@code RemoveCommand} переопределяет метод {@code execute ()} для удаления {@link Shorty} из
 * {@code Collection <? extends Shorty> col}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class RemoveCommand extends AbstractCommand {

    public RemoveCommand(CollectionManager manager) {
        super(manager);
        setDescription("Удаляет элемент из коллекции по его значению.");
    }

    @Override
    public synchronized String execute(String arg) {
            List<Shorty> collection = getManager().getCitizens();
            if (collection.size() != 0) {
                try {
                    if (collection.remove(getManager().getSerializer().fromJson(arg, Shorty.class))) {
                        getManager().save();
                        return "Элемент успешно удален.";
                    } else return "Такого элемента нет в коллекции.";
                } catch (JsonSyntaxException ex) {
                    return "Синтаксическая ошибка JSON. Не удалось удалить элемент.";
                }
            }
            else return "Элемент не с чем сравнивать. Коллекция пуста.";
    }
}