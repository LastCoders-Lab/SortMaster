package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.SortManager;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

public class ResultCommand implements ICommand{

    private final SortManager sortManager;

    public ResultCommand(SortManager sortManager) {
        this.sortManager = sortManager;
    }

    @Override
    public String getName() {
        return "/result";
    }

    @Override
    public String getDescription() {
        return "Результаты сортировок";
    }

    @Override
    public void execute(String[] args) {

    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET + " - " + getDescription() + "\n";
        return help;
    }
}
