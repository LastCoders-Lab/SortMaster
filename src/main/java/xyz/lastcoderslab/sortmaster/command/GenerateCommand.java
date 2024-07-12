package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.tools.Message;

import java.util.Arrays;

public class GenerateCommand implements ICommand{
    private DataManager dataManager;

    public GenerateCommand(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Создает новый массив чисел";
    }

    @Override
    public boolean execute() {
        dataManager.createBySize(10);
        Message.send(Message.get("Ваш массив: " + Arrays.toString(dataManager.getDataArray())));
        Message.send(Message.get("Используйте его для последующих сортировок"));
        return true;
    }

    @Override
    public String help() {
        return null;
    }
}
