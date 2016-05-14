package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.GameObject;

/**
 * Created by nicolas on 13/05/16.
 */
public class MoveStepAction extends AbstractAction implements Action {

    @Override
    public String execute() {
        this.source.remove(this.element.getName());
        this.target.add(this.element);
        return "You won the game!";
    }
}
