package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.GameObject;

/**
 * Created by nicolas on 13/05/16.
 */
public class FindStepAction extends AbstractAction implements Action {

    @Override
    public GameObject execute(GameObject object) {
        return object.find(target.getName());
    }
}
