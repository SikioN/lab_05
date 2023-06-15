package ru.sikion.ZeusMod.src.commands;

import ru.sikion.ZeusMod.src.server.CollectionManager;

/**
 * Класс {@code ClearCommand} переопределяет метод {@code execute ()}, чтобы удалить все элементы из
 * {@code Collection <? extends Shorty> col}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class ClearCommand extends AbstractCommand {

    public ClearCommand(CollectionManager manager) {
        super(manager);
        setDescription("Очистить коллекцию.");
    }

    @Override
    public synchronized String execute() {
        getManager().getCitizens().clear();
        getManager().save();
        return "Коллекция очищена.";
    }
}