package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

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
        Message.send(Message.get("Bye!", MessageType.MAIN));
    }

    @Override
    public String help() {
        String help = TextColor.BOLD + "" + TextColor.YEllOW + getName() + TextColor.RESET + " - " + getDescription() + "\n";
        return help;
    }
}
