package xyz.lastcoderslab.sortmaster;

import xyz.lastcoderslab.sortmaster.tools.Message;
import xyz.lastcoderslab.sortmaster.tools.MessageType;

public class Application {

    public void run(){
        dialog();
    }

    private void dialog() {
        Message.send("Hello", MessageType.MAIN);
        Message.send("Hello", MessageType.ERROR);
        Message.send("Hello", MessageType.NOTICE);
        Message.send("Hello");
    }

}
