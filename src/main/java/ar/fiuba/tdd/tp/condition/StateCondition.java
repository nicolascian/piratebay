package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.model.GameObject;

import java.util.Map;

/**
 * Created by arissola on 11/05/2016.
 */
public class StateCondition extends AbstractCondition<GameObject> {

    private Map<String, String> state;


    public StateCondition(Map state) {
        this.state = state;
    }

    @Override
    public boolean isSatisfiedBy(GameObject gameObject) {

        Map map = gameObject.getState();
        boolean isSatisfied = true;

        for (String key : state.keySet()) {
            if ((map.containsKey(key) && (!state.get(key).equals(map.get(key))))
                    || !map.containsKey(key)) {
                isSatisfied = false;
            }
        }

        return isSatisfied;
    }

}
