package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.entity.CompareMe;
import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.util.Message;
import xyz.lastcoderslab.sortmaster.util.MessageType;
import xyz.lastcoderslab.sortmaster.util.TextColor;

public class LoadCommand implements ICommand{
    private final DataManager dataManager;

    public LoadCommand(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public String getName() {
        return "/load";
    }

    @Override
    public String getDescription() {
        return "Загрузить массив из файла";
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2) {
            Message.send("Не хватает аргументов", MessageType.ERROR);
            return;
        }

        if (args[0].equals("i") || args[0].equals("o")) {
            if (args[0].equals("i")) {
                dataManager.readDataFromFile(args[1], Integer.class);
            }
            if(args[0].equals("o")) {
                dataManager.readDataFromFile(args[1], CompareMe.class);
            }
            Message.send("Загружен массив:\n" + dataManager.dataToPrint(), MessageType.MAIN);
            Message.send("Используйте его для последующих сортировок");
            return;
        }
        Message.send("Неверный аргумент", MessageType.ERROR);
    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET +
                TextColor.YEllOW + " [тип]" +
                TextColor.BLUE + " [path/to/file]"  + TextColor.RESET  +" - " + getDescription() + "\n";
        help += "   " + TextColor.YEllOW + "i"  + TextColor.BLUE + " [n]" + TextColor.RESET + " - массив целых чисел\n";
        help += "   " + TextColor.YEllOW + "o"  + TextColor.BLUE + " [n]" + TextColor.RESET + " - массив объектов\n";
        return help;
    }
}
