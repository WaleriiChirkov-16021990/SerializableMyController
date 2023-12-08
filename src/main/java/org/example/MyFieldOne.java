package org.example;

import java.io.Serializable;

public class MyFieldOne implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int value;

    public MyFieldOne(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyFieldOne{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
