package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.manager.SortManager;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

public class SortCommand implements ICommand{

    private final SortManager sortManager;

    public SortCommand(SortManager sortManager) {
        this.sortManager = sortManager;
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
    public boolean execute(String[] args) {
        return false;
    }

    @Override
    public String help() {
        String help = TextColor.BOLD + getName() + TextColor.RESET + " - " + getDescription() + "\n";
        return help;
    }
}
