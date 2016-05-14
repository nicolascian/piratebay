package ar.fiuba.tdd.tp.connection;


import ar.fiuba.tdd.tp.model.Game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainServer extends AbstractServer {

    public MainServer(Socket socket, Game game) throws IOException {
        super(socket, game);
    }

    protected boolean processOutput(PrintWriter out, String input) {
        out.println("bye!");
        return false;
    }
}
