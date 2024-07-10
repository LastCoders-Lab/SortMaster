package xyz.lastcoderslab.sortmaster.tools;

public class Message {

    public static void send(String text, MessageType type) {
        switch (type) {
            case MAIN:
                text = "\u001B[1;33m" + text + "\u001B[0m";
            case NOTICE:
                text = "\u001B[32m" + text + "\u001B[0m" ;
            case ERROR:
                text = "\u001B[91m" + text + "\u001B[0m";
        }
        System.out.println(text);
    }


    public static void send (String text) {
        send(text, MessageType.OTHER);
    }

}
