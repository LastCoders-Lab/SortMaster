package xyz.lastcoderslab.sortmaster.tools;

public class Message {

    public static String get(String text, MessageType type) {
        switch (type) {
            case MAIN:
                return TextColor.PURPLE + "" + TextColor.BOLD + text + TextColor.RESET;
            case NOTICE:
                return TextColor.GREEN + text + TextColor.RESET;
            case ERROR:
                return TextColor.RED + text + TextColor.RESET;
        }
        return text;
    }


    public static String get (String text) {
        return get(text, MessageType.OTHER);
    }

    public static void send(String message) {
        System.out.println(message);
    }

    public static String formatHelp() {
        return "";
    }
}
