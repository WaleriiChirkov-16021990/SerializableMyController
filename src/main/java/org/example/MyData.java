package org.example;

import java.io.Serializable;

public class MyData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;


    private MyFieldOne myFieldOne;
    private MyFieldTwo myFieldTwo;

    public MyData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyFieldOne getMyFieldOne() {
        return myFieldOne;
    }

    public void setMyFieldOne(MyFieldOne myFieldOne) {
        this.myFieldOne = myFieldOne;
    }

    public MyFieldTwo getMyFieldTwo() {
        return myFieldTwo;
    }

    public void setMyFieldTwo(MyFieldTwo myFieldTwo) {
        this.myFieldTwo = myFieldTwo;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", myFieldOne=" + myFieldOne +
                ", myFieldTwo=" + myFieldTwo +
                '}';
    }
}

