package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.util.Message;
import xyz.lastcoderslab.sortmaster.util.MessageType;
import xyz.lastcoderslab.sortmaster.util.TextColor;

public class ExitCommand implements ICommand{
    @Override
    public String getName() {
        return "/exit";
    }

    @Override
    public String getDescription() {
        return "Выход";
    }

    @Override
    public void execute(String[] args) {
        Message.send("Bye!", MessageType.MAIN);
    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET + " - " + getDescription() + "\n";
        return help;
    }
}
