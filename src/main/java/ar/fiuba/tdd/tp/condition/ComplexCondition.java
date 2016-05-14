package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

/**
 * Created by arissola on 11/05/2016.
 */
public class ComplexCondition extends AbstractCondition<GameObject> {

    List<AbstractCondition> conditions;

    public ComplexCondition(List<AbstractCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {

        for (AbstractCondition condition : conditions) {
            if (not(condition).isSatisfiedBy(gameObject)) {
                return false;
            }

        }
        return true;
    }
}
