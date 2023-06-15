package ru.sikion.ZeusMod.src.commands;

import ru.sikion.ZeusMod.src.server.CollectionManager;
import ru.sikion.ZeusMod.src.tale.Shorty;
import ru.sikion.ZeusMod.src.tale.Town;
import java.util.Comparator;
import java.util.List;

/**
 * {@code SortCommand} класс переопределяет метод {@code execute()} для сортировки {@code Collection<? extends Shorty> col}
 * по одному из параметров: имени {@code Comparator.comparing(Shorty::getName)},
 * репутации {@code Comparator.comparing(Shorty::getReputation)},
 * дате рождения {@code Comparator.comparing(Shorty::getBornDate},
 * капиталу {@code (o1, o2) -> (int) ((o1.getWallet().getMoney() + o1.getAccount().getMoney() + o1.getWallet().getStocks() *
 *                                     Town.GiganticPlantSociety.getStockPriceForSold())- (o2.getWallet().getMoney() +
 *                                     o2.getAccount().getMoney() + o2.getWallet().getStocks() *
 *                                   Town.GiganticPlantSociety.getStockPriceForSold()))}.
 * @author SiKion
 * @version 1.4
 * @since 04
 */
public class SortCommand extends AbstractCommand {

    public SortCommand(CollectionManager manager) {
        super(manager);
        setDescription("Упорядочивает коллекцию по возрастанию по одному из заданных параметров: " +
                "-n по имени, -m по капиталу, -d по дате рождения, -r по репутации.");
    }

    @Override
    public synchronized String execute(String arg) {
            List<Shorty> collection = getManager().getCitizens();
            if (collection.size() != 0) {
                switch (arg) {
                    case "-name", "-n":
                        collection.sort(Comparator.comparing(Shorty::getName));
                        getManager().save();
                        return "Коллекция упорядочена по имени.";
                    case "-date", "-d":
                        collection.sort(Comparator.comparing(Shorty::getCreationDate));
                        getManager().save();
                        return "Коллекция упорядочена по дате рождения.";
                    case "-salary", "-s":
                        collection.sort((o1, o2) -> (int)
                                ((o1.getSalary())
                                        - (o2.getSalary())));
                        getManager().save();
                        return "Коллекция упорядочена по зарплате.";
                    case "-id", "-i":
                        collection.sort(Comparator.comparing(Shorty::getId));
                        getManager().save();
                        return "Коллекция упорядочена по репутации.";
                    default:
                        return "Неправильный параметр. Синтаксис 'sort -{name / salary / date/ id}'.";
                }
            } else return "Коллекция пуста. Нечего упорядочивать.";
    }
}