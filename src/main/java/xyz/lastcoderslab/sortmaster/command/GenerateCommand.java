package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

import java.util.Arrays;

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
        dataManager.createIntArray(10);
        Message.send(Message.get("Ваш массив: " + Arrays.toString(dataManager.getData())));
        Message.send(Message.get("Используйте его для последующих сортировок"));
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
