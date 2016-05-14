package ar.fiuba.tdd.tp.driver;

public interface GameDriver {
    void initGame(String jarPath);

    String sendCommand(String cmd);
}
