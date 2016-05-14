package ar.fiuba.tdd.tp.engine;

import ar.fiuba.tdd.tp.condition.StateCondition;
import ar.fiuba.tdd.tp.model.GameObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Adrián on 5/11/2016.
 */
public class StateConditionTest {

    private GameObject myDoor;

    @Before
    public void setup() {

    }

    @Test
    public void isSatisfiedByBasicTest() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("name", "door");
            put("open", "true");
            put("colour", "red");
        }});

        Assert.assertTrue(doorIsOpenSpecification.isSatisfiedBy(myDoor));

    }

    @Test
    public void isNotSatisfiedByBasicTest() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("name", "door");
            put("open", "false");
            put("colour", "red");
        }});

        Assert.assertTrue(!doorIsOpenSpecification.isSatisfiedBy(myDoor));
        Assert.assertTrue(doorIsOpenSpecification.not(doorIsOpenSpecification).isSatisfiedBy(myDoor));

    }


    @Test
    public void isSatisfiedByTest() {

        StateCondition redDoorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
            put("colour", "red");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("name", "door");
            put("open", "true");
            put("colour", "red");
        }});

        Assert.assertTrue(redDoorIsOpenSpecification.isSatisfiedBy(myDoor));

    }


    @Test
    public void isNotSatisfiedByTest() {

        StateCondition redDoorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
            put("colour", "red");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("name", "door");
            put("open", "true");
            put("colour", "blue");
        }});

        Assert.assertTrue(!redDoorIsOpenSpecification.isSatisfiedBy(myDoor));

    }


    @Test
    public void isNotSatisfiedByLessAttributesTest() {

        StateCondition redBigDoorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
            put("colour", "red");
            put("size", "big");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("open", "true");
        }});

        Assert.assertTrue(!redBigDoorIsOpenSpecification.isSatisfiedBy(myDoor));

    }


    @Test
    public void isSatisfiedByAtomicSpecTest() {

        StateCondition doorIsOpenSpecification = new StateCondition(new HashMap<String, String>() {{
            put("open", "true");
        }});

        StateCondition doorIsRedSpecification = new StateCondition(new HashMap<String, String>() {{
            put("colour", "red");
        }});

        StateCondition doorIsBigSpecification = new StateCondition(new HashMap<String, String>() {{
            put("size", "big");
        }});


        myDoor = new GameObject(new HashMap<String, String>() {{
            put("id", "0");
            put("nombre", "door");
            put("open", "true");
            put("colour", "red");
            put("size", "big");
        }});

        Assert.assertTrue(
                doorIsOpenSpecification.and(doorIsBigSpecification.and(doorIsRedSpecification)).isSatisfiedBy(myDoor));

    }


}
