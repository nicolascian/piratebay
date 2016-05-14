package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

/**
 * Created by nicolas on 13/05/16.
 */
public abstract class AbstractAction implements Action {
    protected List<Action> steps;

    public GameObject getSource() {
        return source;
    }

    public void setSource(GameObject source) {
        this.source = source;
    }

    protected GameObject source;
    protected GameObject target;

    public GameObject getElement() {
        return element;
    }

    public void setElement(GameObject element) {
        this.element = element;
    }

    protected GameObject element;
    protected Game game;
    protected String name;
    protected List<Result> resultList;
    protected Action nextAction;

    public void setNextAction(Action nextAction) {
        this.nextAction = nextAction;
    }

    public GameObject getTarget() {
        return target;
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }

    public void add(Action action) {
        this.steps.add(action);
    }
}
