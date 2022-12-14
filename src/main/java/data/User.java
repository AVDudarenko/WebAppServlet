package data;

import java.io.Serializable;

/**
 * Java bean class
 */
public class User implements Serializable {

    private String name;
    private int age;

    public User(){
        this.name = "";
        this.age = 0;
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
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
}
