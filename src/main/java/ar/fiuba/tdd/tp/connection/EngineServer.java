package ar.fiuba.tdd.tp.connection;


import ar.fiuba.tdd.tp.model.Game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class EngineServer extends AbstractServer {

    public EngineServer(Socket socket, Game game) throws IOException {
        super(socket, game);
    }

    protected boolean processOutput(PrintWriter out, String input) {
        //out.println(input);
        return true;
    }
}
