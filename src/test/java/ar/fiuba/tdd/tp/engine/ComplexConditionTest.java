package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.condition.AbstractCondition;
import ar.fiuba.tdd.tp.condition.ComplexCondition;
import ar.fiuba.tdd.tp.condition.ContainsCondition;
import ar.fiuba.tdd.tp.condition.StateCondition;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Adrián on 5/12/2016.
 */
public class ComplexConditionTest {


    @Test
    public void isSatisfiedBy() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});

        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {{
            put("colour", "red");
        }});

        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {{
            put("size", "big");
        }});


        GameObject myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "door");
            put("open", "true");
            put("colour", "red");
            put("size", "big");
        }});

        List<AbstractCondition> specs = new ArrayList<AbstractCondition>();
        specs.add(doorIsOpenSpecification);
        specs.add(doorIsRedSpecification);
        specs.add(doorIsBigSpecification);

        ComplexCondition redBigDoorIsOpenSpecification = new ComplexCondition(specs);

        Assert.assertTrue(redBigDoorIsOpenSpecification.isSatisfiedBy(myDoor));
    }


    @Test
    public void isNotSatisfiedBy() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});

        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {{
            put("colour", "blue");
        }});

        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {{
            put("size", "big");
        }});


        GameObject myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "door");
            put("open", "true");
            put("colour", "red");
            put("size", "big");
        }});

        List<AbstractCondition> specs = new ArrayList<AbstractCondition>();
        specs.add(doorIsOpenSpecification);
        specs.add(doorIsRedSpecification);
        specs.add(doorIsBigSpecification);

        ComplexCondition redBigDoorIsOpenSpecification = new ComplexCondition(specs);

        Assert.assertTrue(!redBigDoorIsOpenSpecification.isSatisfiedBy(myDoor));
    }

    public void playerCanOpenSpecification() {


        GameObject door = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "puerta");
            put("key", "gold key");
            put("colour", "red");
            put("size", "big");
        }});


        GameObject key = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "key");
            put("key", "gold key");
        }});

        GameObject player = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "player");
            put("lla", "true");
            put("colour", "red");
            put("size", "big");
        }});


        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributeValue("key"));

        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));

        player.add(key);

        Assert.assertTrue(playerCanOpenDoor.isSatisfiedBy(player));

    }


    public void playerCanNotOpenSpecification() {

        GameObject incorrectKey = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "key");
            put("key", "incorrect key");
        }});

        GameObject player = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "player");
            put("lla", "true");
            put("colour", "red");
            put("size", "big");
        }});

        GameObject door = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "puerta");
            put("key", "gold key");
            put("colour", "red");
            put("size", "big");
        }});

        ContainsCondition playerCanOpenDoor = new ContainsCondition(door.getAttributeValue("key"));

        Assert.assertFalse(playerCanOpenDoor.isSatisfiedBy(player));

        player.add(incorrectKey);

        Assert.assertTrue(playerCanOpenDoor.isSatisfiedBy(player));


    }


}
