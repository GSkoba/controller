package com.skobelev.web.api.util;

public class Controller {
    private int id;
    private String name;

    public Controller() {
    }

    public Controller(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
