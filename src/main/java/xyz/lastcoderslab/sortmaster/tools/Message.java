package xyz.lastcoderslab.sortmaster.tools;

public class Message {

    public static String get(String text, MessageType type) {
        switch (type) {
            case MAIN:
                return TextColor.BOLD + text + TextColor.RESET;
            case NOTICE:
                return TextColor.GREEN + text + TextColor.RESET;
            case ERROR:
                return TextColor.RED + "ERROR: " + text + TextColor.RESET;
        }
        return text;
    }

    public static String get (String text) {
        return get(text, MessageType.OTHER);
    }

    public static void send(String text, MessageType type) {
        System.out.println(get(text, type));
    }

    public static void send(String text) {
        System.out.println(get(text));
    }

    public static String formatHelp() {
        return "";
    }
}
