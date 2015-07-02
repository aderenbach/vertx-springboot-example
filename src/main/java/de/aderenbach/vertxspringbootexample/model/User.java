package de.aderenbach.vertxspringbootexample.model;

/**
 * Created by aderenbach on 01.07.15.
 */
public class User {

    private final String id;
    private final String name;


    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
