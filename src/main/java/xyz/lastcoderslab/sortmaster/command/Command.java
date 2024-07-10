package xyz.lastcoderslab.sortmaster.command;

public interface Command {
    String getName();

    String getDescription();

    boolean execute();

    void help();
}
