package xyz.lastcoderslab.sortmaster.tools;

public class Message {

    public static String get(String text, MessageType type) {
        switch (type) {
            case MAIN:
                return "\u001B[1;33m" + text + "\u001B[0m";
            case NOTICE:
                return "\u001B[32m" + text + "\u001B[0m" ;
            case ERROR:
                return "\u001B[91m" + text + "\u001B[0m";
        }
        return text;
    }


    public static String get (String text) {
        return get(text, MessageType.OTHER);
    }

    public static void send(String message) {
        System.out.println(message);
    }

}
