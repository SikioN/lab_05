package ru.sikion.ZeusMod.src.commands;

import com.google.gson.JsonSyntaxException;
import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.tale.Shorty;
import java.util.LinkedList;

/**
 * Класс {@code ImportCommand} переопределяет метод {@code execute ()} для добавления
 * {@code Collection <? extends Shorty> col} который был получен от клиента к серверу коллекции.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class ImportCommand extends AbstractCommand {

    public ImportCommand(CollectionManager manager) {
        super(manager);
        setDescription("Добавить объекты из файла на вашем компьютере в коллекцию и сохранить их на сервере.");
    }

    @Override
    public synchronized String execute(String arg) {
            int beginSize = getManager().getCitizens().size();
            try {
                LinkedList<Shorty> importedShorty = getManager().getSerializer().fromJson(arg, getManager().getCollectionType());
                getManager().getCitizens().addAll(importedShorty);
                getManager().save();
                return "Из вашего файла было добавлено " + (getManager().getCitizens().size() - beginSize) + " элементов.";
            } catch (JsonSyntaxException ex) {
                return "Синтаксическая ошибка JSON в импортированных данных.";
            }
    }
}