package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.connection.Client;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        try {

            System.out.println("sending request to peer....");
            Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
            System.out.println("successfully conneted");
            new Client(socket);

            InputStream inputStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream, true, "UTF-8");

            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    printStream.println(line);
                    if (".".equals(line)) {
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

/*import ar.fiuba.tdd.tp.model.GameBuilder;
import ar.fiuba.tdd.tp.server.BuilderLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        GameBuilder builder = BuilderLoader.load(args[0]);
        builder.build();*/
    }
}
