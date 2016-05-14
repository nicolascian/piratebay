package ar.fiuba.tdd.tp.game;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.MoveStepAction;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameBuilder;
import ar.fiuba.tdd.tp.model.GameObject;

/**
 * Created by nicolas on 12/05/16.
 */
public class FetchQuestBuilder implements GameBuilder {
    Game build() {
        Game game = new Game();
        // Los elementos del juego
        GameObject player = new GameObject("Player");
        GameObject stick = new GameObject("Stick");
        GameObject room = new GameObject("Room");
        // There is a stick on the room
        room.add(player);
        room.add(stick);
        // Colocamos el juego en stage
        game.setStage(room);
        // Las acciones posibles
        ComplexAction lookAround = new ComplexAction();
        lookAround.setName("look around");

        ComplexAction pick = new ComplexAction();
        pick.setName("pick");
        Action moveAction = new MoveStepAction();
        pick.add(moveAction);
        moveAction.setSource(room);
        moveAction.setTarget(player);

        game.addAction(lookAround.getName(), lookAround);
        game.addAction(pick.getName(), pick);

        return game;
    }
}
