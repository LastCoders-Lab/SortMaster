package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateCommand implements ICommand{
    private final DataManager dataManager;

    public GenerateCommand(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public String getName() {
        return "/generate";
    }

    @Override
    public String getDescription() {
        return "Создает новый набор данных для сортировки";
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2) {
            Message.send("Не хватает аргументов", MessageType.ERROR);
            return;
        }
        if (args[0].equals("i") || args[0].equals("o")) {
            if (args[1].matches("\\d+")) {
                if (args[0].equals("i")) {
                    dataManager.createIntArray(Integer.parseInt(args[1]));
                }
                if(args[0].equals("o")) {
                    dataManager.createObjectsArray(Integer.parseInt(args[1]));
                }
                Message.send("Ваш массив:\n" + dataManager.dataToString());
                Message.send("Используйте его для последующих сортировок");
                return;
            }
            Message.send("Значение второго аргумента должно быть целым положительным числом", MessageType.ERROR);
        }
        Message.send("Неверный аргумент", MessageType.ERROR);

    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET +
        TextColor.YEllOW + " [тип]" +
                TextColor.BLUE + " [размерность]" + TextColor.RESET +" - " + getDescription() + "\n";
        help += "   " + TextColor.YEllOW + "i"  + TextColor.BLUE + " [n]" + TextColor.RESET + " - массив целых чисел\n";
        help += "   " + TextColor.YEllOW + "o"  + TextColor.BLUE + " [n]" + TextColor.RESET + " - массив объектов\n";
        //help += "   " + TextColor.YEllOW + "f"  + TextColor.BLUE + " [path/to/file]" + TextColor.RESET + " - загрузить из файла [имя файла]\n";
        return help;
    }
}
