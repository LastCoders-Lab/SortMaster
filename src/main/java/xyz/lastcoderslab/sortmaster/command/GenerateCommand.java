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
        return "Создает новуый набор данных для сортировки";
    }

    @Override
    public void execute(String[] args) {
        dataManager.createBySize(10);
        Message.send(Message.get("Ваш массив: " + Arrays.toString(dataManager.getDataArray())));
        Message.send(Message.get("Используйте его для последующих сортировок"));
    }


    @Override
    public String help() {
        String help = TextColor.BOLD + getName() + TextColor.RESET + " - " + getDescription() + "\n" +
                "   " + TextColor.YEllOW + "a"  + TextColor.BLUE + " [n]" + TextColor.RESET + " - массив целых чисел [размерность]\n" +
                "   " + TextColor.YEllOW + "f"  + TextColor.BLUE + " [path/to/file]" + TextColor.RESET + " - загрузить из файла [имя файла]\n";
        return help;
    }
}
