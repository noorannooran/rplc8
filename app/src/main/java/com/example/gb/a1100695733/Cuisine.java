package com.example.gb.a1100695733;

/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */

public class Cuisine {
    private String name;
    private String description;

    public static final Cuisine[] cuisines ={
            new Cuisine("Bajoran", "Exotic offerings from Bajor"),
            new Cuisine("Cardassian", "Delicacies from Cardassia"),
            new Cuisine("Ferengi", "It'll grow on you"),
            new Cuisine("Human", "Food from Earth"),
            new Cuisine("Klingon", "So fresh it's still alive"),
            new Cuisine("Vulcan", "Vegetarian food from Vulcan")
    };

    public Cuisine(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
