package com.testproject.pets.businesslogic;

import java.io.Serializable;

/**
 * Pet DAO class
 */
public class Pet implements Serializable {
    private int id;
    private String name;
    private int age;
    private String color;
    private String owner;

    public Pet() {
        this.id = 0;
        this.name = "";
        this.age = 0;
        this.color = "";
        this.owner = "";
    }

    public Pet(String name, int age, String color, String owner) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.owner = owner;
    }

    public Pet(int id, String name, int age, String color, String owner) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
