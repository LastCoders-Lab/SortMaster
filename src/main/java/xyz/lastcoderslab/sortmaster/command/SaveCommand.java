package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.util.Message;
import xyz.lastcoderslab.sortmaster.util.MessageType;
import xyz.lastcoderslab.sortmaster.util.TextColor;

import java.io.File;

public class SaveCommand implements ICommand{

    private final DataManager dataManager;

    public SaveCommand(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public String getName() {
        return "/save";
    }

    @Override
    public String getDescription() {
        return "Сохранить в файл";
    }

    @Override
    public void execute(String[] args) {
        if(dataManager.getData() == null) {
            Message.send("Сначала сгенерируйте или загрузите данные", MessageType.ERROR);
            return;
        }
        String fileName = DataManager.FILE_DIR + File.separator + "jsonFile.json";
        dataManager.writeDataToFile(fileName);
        Message.send("Ваш массив сохранен в файле: " + fileName);
    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() +
                TextColor.RESET  +" - " + getDescription() + "\n";
        return help;
    }
}
