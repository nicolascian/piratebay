package ar.fiuba.tdd.tp.connection;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private Thread thread;
    private Socket socket;
    private boolean finished = false;
    private PrintWriter out;


    public Client(Socket socket) {
        this.socket = socket;
        this.out = null;
        thread = new Thread(this);
        thread.start();
    }

    public Client(Socket socket, PrintWriter out) {
        this.socket = socket;
        this.out = out;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while (!finished) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    finished = true;
                } else {
                    if (out != null) {
                        out.println(line);
                    } else {
                        System.out.println(line);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
