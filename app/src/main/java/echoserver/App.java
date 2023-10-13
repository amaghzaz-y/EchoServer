package echoserver;

import java.io.IOException;
import java.net.Socket;

public class App {
    public static void main(String args[]) throws IOException {

        String test = "";
        ToolsIO screen = new ToolsIO();
        ToolsIO network = new ToolsIO(new Socket("192.168.1.77", 5999));
        // x.toScreen("test_screen");
        // my first commit
        screen.toScreen(network.fromNetwork());
        network.toNetwork(screen.fromScreen());

        while (!test.equals("quit")) {
            test = screen.fromScreen();
            network.toNetwork(test);
            screen.toScreen(network.fromNetwork());
        }
    }
}
