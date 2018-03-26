package com.example.gb.a1100695733;

import java.io.Serializable;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class Dish implements Serializable {
    private Restaurant restaurant;
    private String name;
    private double price;

    public static final Dish[] dishes1 = {
            //Bajoran
            new Dish("Groatcake", 1),
            new Dish("Hasperat Souffle", 2),
            new Dish("Katterpod", 0.5),
            new Dish("Mapa Bread", 0.5)
    };
    public static final Dish[] dishes2 ={
            //Bajoran 2
            new Dish("Makapa Bread", 0.5),
            new Dish("Ratamba Stew", 1.5),
            new Dish("Larish Pie", 2),
            new Dish("Jumja Stick", 0.5)
    };
    public static final Dish[] dishes3 ={
            //Cardassian
            new Dish("Kanar", 1),
            new Dish("Fish Juice", 0.5),
            new Dish("Regova Egg", 1),
            new Dish("Rokassa Juice", 0.75)
    };
    public static final Dish[] dishes4 ={
            //Cardassian2
            new Dish("Rulot Seed", 0.5),
            new Dish("Sem'hal Stew", 2),
            new Dish("Taspar Egg with Yamok", 2),
            new Dish("Zabu Stew", 2.5)
    };
    public static final Dish[] dishes5={
            //Ferengi 1
            new Dish("Black hole", 5),
            new Dish("Crab", 5),
            new Dish("Flaked Blood Flea", 2.5),
            new Dish("Jellied Gree-Worm", 2.5)
    };
    public static final Dish[] dishes6 ={
            //Ferengi2
            new Dish("Lokar Bean", 3),
            new Dish("Tube Grub", 2.5),
            new Dish("Eelwaser", 5)
    };
    public static final Dish[] dishes7 ={
            //human1
            new Dish("Foot Feta-ish Burger", 3),
            new Dish("Tunami", 2.5),
            new Dish("Sacred Cow", 3),
            new Dish("Totally Radish Burger", 2.5)
    };
    public static final Dish[] dishes8={
            //human2
            new Dish("BBQ Chicken Wings", 2),
            new Dish("Hot Spicy Wings", 2),
            new Dish("Honey Wings", 2),
            new Dish("Triple Fry Wings", 3)
    };
    public static final Dish[] dishes9={
            //klingon 1
            new Dish("Bloodwine", 2),
            new Dish("Gagh", 2.5),
            new Dish("Mot'luch", 3),
            new Dish("Pipius Claw", 4)
    };
    public static final Dish[] dishes10={
            //klingon2
            new Dish("Racht", 2.5),
            new Dish("Raktajino", 1),
            new Dish("Heart of Targ", 3.5),
            new Dish("Zilm'kach", 3)
    };
    public static final Dish[] dishes11= {
            //Vulcan1
            new Dish("Gespar", 2),
            new Dish("Jumbo Mollusk", 4),
            new Dish("Plomeek Broth", 3)
    };
    public static final Dish[] dishes12={
            //Vulcan2
            new Dish("Pok Tar", 0.5),
            new Dish("Spice Tea", 0.5),
            new Dish("Redspice", 0.25)
    };
    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
