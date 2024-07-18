package xyz.lastcoderslab.sortmaster;

import xyz.lastcoderslab.sortmaster.command.*;
import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.manager.SortManager;
import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;
import xyz.lastcoderslab.sortmaster.tools.TextColor;

import java.util.Arrays;
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
        commands.put("/sort", new SortCommand(sortManager));
        commands.put("/result", new ResultCommand(sortManager));
        commands.put("/exit", new ExitCommand());


        System.out.println(TextColor.ORANGE + "|~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println(TextColor.ORANGE + "| S o r t M a s t e r |");
        System.out.println(TextColor.ORANGE + "|~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println(TextColor.GREY + "coded by LastCoders-Lab\n");

        dialog();
    }

    private void dialog() {
        System.out.println(help());
        sc = new Scanner(System.in);

        do {
            sc = new Scanner(System.in);
            String commandLine = sc.nextLine();
            String[] args;
            args = commandLine.split(" ");
            args[0] = args[0].trim();
            if (!args[0].startsWith("/")) {
                Message.send("Неверный формат команды", MessageType.ERROR);
            }
            else {
                cmd = args[0];
                if(args.length > 1) {
                    args = Arrays.copyOfRange(args,1, args.length);
                }
                else args = new String[0];

                if(commands.containsKey(cmd)) {
                    commands.get(cmd).execute(args);
                }
                else {
                    Message.send("Неизвесная команда", MessageType.ERROR);
                }
            }
        }
        while (! cmd.equals("/exit"));
    }

    public String help() {
        String s =Message.get("Доступные команды:\n", MessageType.MAIN);
        for(String cmdKey : commands.keySet()) {
            s += commands.get(cmdKey).help();
        }
        return s;
    }


}
