package xyz.lastcoderslab.sortmaster.tools;

public enum TextColor {
    RED(31),
    YEllOW(33),
    ORANGE(93),
    BLUE(34),
    GREEN(32),
    PURPLE(35),
    GREY(37),
    BOLD(1),
    RESET(0);

    private final int colorCode;


    TextColor(int colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return String.format("\u001B[%dm", colorCode);
    }
}
