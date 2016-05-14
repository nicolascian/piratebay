package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;

/**
 * Created by arissola on 11/05/2016.
 */
public class ContainsCondition extends AbstractCondition<GameObject> {

    private String name;


    public ContainsCondition(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {
        return gameObject.find(name) != null;
    }

}
