package ar.fiuba.tdd.tp.connection;


import ar.fiuba.tdd.tp.model.Game;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public abstract class AbstractServer extends Thread {

    protected Socket socket;
    protected Game game;

    public AbstractServer(Socket socket, Game game) throws IOException {
        this.socket = socket;
        this.game = game;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets
                    .UTF_8), true);
            processInput(in, out);
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected String connectCommand(BufferedReader in, PrintWriter out, String input) throws IOException {
        if (input.startsWith("connect ")) {
            String ipPort = input.replace("connect ", "");
            String[] data = ipPort.split(":");
            String ip = data[0];
            String port = data[1];
            input = connectGameServer(in, out, ip, port);
        }
        return input;
    }

    private String connectGameServer(BufferedReader in, PrintWriter out, String ip, String port) throws IOException {
        String input;
        Integer numPort = Integer.parseInt(port);
        Socket socket = new Socket(ip, numPort);
        new Client(socket, out);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream, true, "UTF-8");
        out.println("Welcome to " + Server.getKeyByValue(numPort));
        while (true) {
            String line = in.readLine();
            if (line != null) {
                if (line.startsWith("exit game")) {
                    input = "exit game";
                    break;
                }
                printStream.println(line);
            }
        }
        return input;
    }

    private void processInput(BufferedReader in, PrintWriter out) throws IOException {
        boolean exit = false;
        while (!exit) {
            String input = in.readLine();
            if (input != null) {
                input = connectCommand(in, out, input);
                if (input.equals("exit game")) {
                    exit = processOutput(out, input);
                } else {
                    if (game != null) {
                        String response = game.doCommand(input);
                        out.println(response);
                    } else {
                        out.println(input);
                    }
                }
            }
        }
    }

    protected abstract boolean processOutput(PrintWriter out, String input);
}
