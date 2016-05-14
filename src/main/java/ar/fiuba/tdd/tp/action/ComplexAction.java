package ar.fiuba.tdd.tp.action;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;

import java.util.List;

/**
 * Created by leandro on 10/05/16.
 */
public class ComplexAction extends AbstractAction implements Action {

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() {
        //TODO sacar la lista de steps
        Action step = this.steps.get(0);

        step.setTarget(this.target);
        GameObject result = step.execute(object);
        while (step.hasNext()) {
            Action next = step.getNextAction();
            next.setTarget(result);
            result = next.execute(object);
        }

        return "ok";
    }
}
