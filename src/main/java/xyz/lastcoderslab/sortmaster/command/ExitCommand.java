package xyz.lastcoderslab.sortmaster.command;

import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;

public class ExitCommand implements ICommand{
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Выход";
    }

    @Override
    public boolean execute() {
        Message.send(Message.get("Bye!", MessageType.MAIN));
        return true;
    }

    @Override
    public String help() {
        return null;
    }
}
