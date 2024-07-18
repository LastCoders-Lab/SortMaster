package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.tools.TextColor;

public class LoadCommand implements ICommand{
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

    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET +
                TextColor.BLUE + " [path/to/file]\n";
        return help;
    }
}
