package xyz.lastcoderslab.sortmaster;

import xyz.lastcoderslab.sortmaster.command.ExitCommand;
import xyz.lastcoderslab.sortmaster.command.GenerateCommand;
import xyz.lastcoderslab.sortmaster.command.ICommand;
import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.manager.SortManager;
import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private DataManager dataManager;
    private SortManager sortManager;
    private Scanner sc;
    private String cmd = "";
    Map<String, ICommand> commands = new LinkedHashMap<>();

    public void run(){
        dataManager = new DataManager();
        sortManager = new SortManager(dataManager);

        commands.put("/generate", new GenerateCommand(dataManager));
        commands.put("/exit", new ExitCommand());

        dialog();
    }

    private void dialog() {
        System.out.println(help());
        sc = new Scanner(System.in);
        do {
            sc = new Scanner(System.in);
            cmd = sc.nextLine();
            if(commands.containsKey(cmd)) {
                commands.get(cmd).execute();
            }
            else {
                Message.send(Message.get("Unknown command", MessageType.ERROR));
            }
        }
        while (! cmd.equals("/exit"));
    }

    public String help() {
        String s =Message.get("Доступные команды:\n", MessageType.MAIN);
        for(String cmdKey : commands.keySet()) {
            s += cmdKey + " - " + commands.get(cmdKey).getDescription() + "\n";
        }
        return s;
    }

}
