package echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//? System.out -> stdout
//? System.err -> stderr

class ToolsIO {

	private BufferedReader readScreen;
	private PrintStream writeScreen;

	ToolsIO() {

		readScreen = new BufferedReader(new InputStreamReader(System.in));
		writeScreen = System.out;

	}

	ToolsIO(Socket socket) throws IOException {

		readScreen = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writeScreen = new PrintStream(socket.getOutputStream());

	}

	public void toScreen(String texte) {

		writeScreen.println(texte);
	}

	public String fromScreen() throws IOException {

		String line = readScreen.readLine();
		// writeScreen.println(line);
		return line;
	}

	public void toNetwork(String texte) {
		writeScreen.println(texte);
	}

	public String fromNetwork() throws IOException {
		String txt = readScreen.readLine();
		// writeScreen.println(txt);
		return txt;
	}
}