package ar.fiuba.tdd.tp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameObject {
    private String name;
    private Map<String, String> attributes;
    private List<GameObject> objects;

    public GameObject(Map map) {
        this.attributes = map;
    }

    public GameObject(String name) {
        objects = new ArrayList<>();
        attributes = new HashMap<>();
        this.name = name;
    }

    public GameObject find(String name) {
        GameObject gameObject = null;
        for (GameObject object : objects) {
            if (object.getName().equals(name)) {
                gameObject = object;
                break;
            }
        }
        return gameObject;
    }

    public void add(GameObject object) {
        object.add(object);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void remove(String name) {
        objects.remove(find(name));
    }

    public void addAtribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttributeValue(String key) {
        return attributes.get(key);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getState() {
        return this.attributes;
    }
}
