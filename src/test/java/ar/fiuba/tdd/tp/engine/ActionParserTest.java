package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.action.Action;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leandro on 11/05/16.
 */
public class ActionParserTest {
    private ActionParser actionParser;
    private Game game;

    @Before
    public void setup() {
        game = createGame();
        actionParser = new ActionParser(game);
        game.setActionParser(actionParser);
        actionParser.setValidActionsRegex(new ArrayList<>());
        actionParser.setValidObjectsRegex(new ArrayList<>());
    }

    private List<String> createValidActionsRegexList() {
        return Arrays.asList("pick", "open", "look around", "test", "leave");
    }

    private List<String> createValidObjectsRegexList() {
        return Arrays.asList("key", "stick", "wolf", "treasure");
    }

    private Game createGame() {
        Game game = new Game();
        game.setName("Name");
        List<Action> actions = new ArrayList<>();
        actions.add(createAction("test"));
        game.setActions(actions);
        return game;
    }

    private Action createAction(String name) {
        Action action = new Action() {
            @Override
            public String execute(List<GameObject> objects) {
                return null;
            }
        };
        action.setName(name);
        return action;
    }

    @Test
    public void parseCommandInvalidActionNameAndValidObjectTest() {
        Action action = actionParser.interpret("test key");
        Assert.assertTrue(action == null);
    }

    @Test
    public void parseCommandValidActionNameAndValidObjectTest() {
        actionParser.setValidActionsRegex(createValidActionsRegexList());
        actionParser.setValidObjectsRegex(createValidObjectsRegexList());
        Action action = actionParser.interpret("test key");
        Assert.assertTrue(action.getName().equals("test"));
    }

    @Test
    public void parseCommandValidActionNameAndInvalidObjectTest() {
        actionParser.setValidActionsRegex(createValidActionsRegexList());
        Action action = actionParser.interpret("test key");
        Assert.assertTrue(action == null);
    }
}
