package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.GameObject;

public interface Action {

    void add(Action action);
    String execute();
    void setTarget(GameObject target);
    void setNextAction(Action nextAction);

}
