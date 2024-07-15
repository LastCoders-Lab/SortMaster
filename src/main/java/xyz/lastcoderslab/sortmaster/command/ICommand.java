package xyz.lastcoderslab.sortmaster.command;

import java.util.HashMap;
import java.util.Map;

public interface ICommand {

    String getName();

    String getDescription();

    void execute(String[] args);

    //Map<String, String> arguments();

    String help();
}
