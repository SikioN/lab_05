package ru.sikion.ZeusMod.src.commands;

import com.google.gson.JsonSyntaxException;
import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.tale.Shorty;
import java.util.List;

/**
* Класс {@code RemoveAllCommand} переопределяет метод {@code execute ()} для удаления всех элементов из
 * {@code Collection <? extends Shorty> col}, которые меньше чем {@link Shorty}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class RemoveAllCommand extends AbstractCommand {

    public RemoveAllCommand(CollectionManager manager) {
        super(manager);
        setDescription("Удалить из коллекции все предметы, эквивалентные данному.");
    }

    @Override
    public synchronized String execute(String arg) {
            List<Shorty> collection = getManager().getCitizens();
            if (collection.size() != 0) {
                int beginSize = collection.size();
                try {
                    collection.removeIf(p -> p.equals(getManager().getSerializer().fromJson(arg, Shorty.class)));
                    getManager().save();
                    return "Удалено из коллекции " + (beginSize - collection.size()) + " элементов.";
                } catch (JsonSyntaxException ex) {
                    return "Синтаксическая ошибка JSON. Не удалось удалить элемент.";
                }
            }
            else return "Элемент не с чем сравнивать. Коллекция пуста.";
    }
}