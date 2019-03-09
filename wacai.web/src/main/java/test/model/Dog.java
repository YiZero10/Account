package test.model;


import java.util.*;

/**
 *
 */
public class Dog {

    /**
     * Default constructor
     */
    public Dog() {
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String color;

    /**
     *
     */
    public void run() {
        System.out.println("跑");
    }

    /**
     *
     */
    public String getName() {

        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public String getColor() {

        return color;
    }

    /**
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

}