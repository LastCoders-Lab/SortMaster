package xyz.lastcoderslab.sortmaster.command;

public interface ICommand {
    String getName();

    String getDescription();

    boolean execute();

    String help();
}
