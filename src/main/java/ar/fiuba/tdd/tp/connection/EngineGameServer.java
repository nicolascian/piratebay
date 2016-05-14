package ar.fiuba.tdd.tp.connection;


import ar.fiuba.tdd.tp.model.Game;

import java.io.IOException;
import java.net.Socket;

public class EngineGameServer extends AbstractGameServer {

    public EngineGameServer(int port, String gameName) {
        super(port, gameName);
    }

    protected AbstractServer makeServer(Socket socket, Game gameInstance) throws IOException {
        return new EngineServer(socket, gameInstance);
    }
}
