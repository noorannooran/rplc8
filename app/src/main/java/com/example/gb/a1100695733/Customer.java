package com.example.gb.a1100695733;

import java.io.Serializable;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class Customer implements Serializable {
    private String first_name;
    private String last_name;
    private String address;
    private String credit_card;
    private String favourite_dish;
    private String favourite_cuisine;
    private String food_restrictions;

    public Customer(String first_name, String last_name, String address, String credit_card, String favourite_dish, String favourite_restaurant, String food_restrictions) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.credit_card = credit_card;
        this.favourite_dish = favourite_dish;
        this.favourite_cuisine = favourite_restaurant;
        this.food_restrictions = food_restrictions;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public String getFavourite_dish() {
        return favourite_dish;
    }

    public void setFavourite_dish(String favourite_dish) {
        this.favourite_dish = favourite_dish;
    }

    public String getFavourite_Cuisine() {
        return favourite_cuisine;
    }

    public void setFavourite_restaurant(String favourite_restaurant) {
        this.favourite_cuisine = favourite_restaurant;
    }
    

    @Override
    public String toString() {
        return "Customer Information: " + "\n" +
                "Name: " + first_name + " " + last_name + "\n" +
                "Address: " + address + "\n" +
                "Credit Card: " + credit_card + "\n" +
                "Favourite Dish: " + favourite_dish + "\n" +
                "Favourite Cuisine: " + favourite_cuisine + "\n" +
                "Food Restrictions: " + food_restrictions + "\n";
    }
}

