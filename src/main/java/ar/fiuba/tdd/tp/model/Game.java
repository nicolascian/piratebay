package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.engine.ActionParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private ActionParser actionParser;
    private String name;
    private GameObject stage;
    private Map<String,ComplexAction> actions;

    public Game() {
        this.actions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameObject getStage() {
        return stage;
    }

    public void setStage(GameObject stage) {
        this.stage = stage;
    }

    public void addAction(String name, ComplexAction action) {
        this.actions.put(name,action);
    }

    public ComplexAction getAction(String name) {
        this.actions.get(name);
    }

    public String doCommand(String command) {
        Action action = actionParser.interpret(command);
        return action.execute(stage.getObjects());
    }

    public void setActionParser(ActionParser actionParser) {
        this.actionParser = actionParser;
    }
}
