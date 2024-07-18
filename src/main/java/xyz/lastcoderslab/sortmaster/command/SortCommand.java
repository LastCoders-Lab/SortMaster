package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.manager.SortManager;
import xyz.lastcoderslab.sortmaster.manager.sorter.Sorter;
import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

import java.util.Map;

public class SortCommand implements ICommand{

    private final SortManager sortManager;

    private final Map<String, Sorter> sorts;

    public SortCommand(SortManager sortManager) {
        this.sortManager = sortManager;
        sorts = sortManager.getSorts();
    }

    @Override
    public String getName() {
        return "/sort";
    }

    @Override
    public String getDescription() {
        return "Выполнить сортировку";
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 1) {
            Message.send("Не хватает аргументов", MessageType.ERROR);
            return;
        }
        if(!sorts.containsKey(args[0])) {
            Message.send("Неверный аргумент", MessageType.ERROR);
            return;
        }
        Sorter sorter = sortManager.doSort(args[0]);
        Message.send("Результаты сортировки " + args[0] + ":", MessageType.MAIN);
        System.out.println("Исходный массив:");
        System.out.println(DataManager.dataToPrint(sorter.getInputArray()));
        System.out.println("Результат:");
        System.out.println(DataManager.dataToPrint(sorter.getOutputArray()));
        System.out.println("Количество перестановок: " + sorter.getSwapCount());
        System.out.println("Затрачено времени(в наносекундах): " + sorter.getSortingTime());
        System.out.println("\n");
    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET +
                TextColor.YEllOW + " [ВидСортировки]" + TextColor.RESET +" - " + getDescription() + "\n";
        for(String type : sorts.keySet()) {
            help += "   " + TextColor.YEllOW + type + TextColor.RESET + "\n";
        }
        return help;
    }
}
