package com.example.gb.a1100695733;

import java.io.Serializable;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class Restaurant implements Serializable{
    private int imageResourceId;
    private String cuisine;
    private String name;
    private Dish[] dishes;

    public static final Restaurant[] bajoranRestaurants = {
            new Restaurant("Bajoran", "Emissarie's Kitchen", Dish.dishes1, R.drawable.emissaries_logo),
            new Restaurant("Bajoran", "Vedek Vedek", Dish.dishes2, R.drawable.vedek_logo)};
    public static final Restaurant[] cardassianRestaurants = {
            new Restaurant("Cardassian", "Hulim House", Dish.dishes3, R.drawable.hulimhouse_logo),
            new Restaurant("Cardassian", "Bendra's", Dish.dishes4, R.drawable.bendras_logo)};
    public static final Restaurant[] ferengiRestaurants = {
            new Restaurant("Ferengi", "Quarks", Dish.dishes5, R.drawable.quarks_logo),
            new Restaurant("Ferengi", "Yop, Yoba, Yop", Dish.dishes6, R.drawable.yopyaboyop_logo)};
    public static final Restaurant [] humanRestaurants = {
            new Restaurant("Human", "Bob's Burgers", Dish.dishes7, R.drawable.bobsburgers_logo),
            new Restaurant("Human", "Wong's Wings", Dish.dishes8, R.drawable.wongs_logo)};
    public static final Restaurant [] klingonRestaurants ={
            new Restaurant("Klingon", "House of Gagh", Dish.dishes9, R.drawable.house_gagh_logo),
            new Restaurant("Klingon", "Pe'el", Dish.dishes10, R.drawable.peel_logo)};
    public static final Restaurant [] vulcanRestaurants ={
            new Restaurant("Vulcan", "Af'tum", Dish.dishes11, R.drawable.aftum_logo),
            new Restaurant("Vulcan", "Avon Ha-Kel", Dish.dishes12, R.drawable.avonhakel_logo)
    };
    public Restaurant(String cuisine, String name, int id) {
        this.cuisine = cuisine;
        this.name = name;
        this.imageResourceId= id;
    }

    public Restaurant(String cuisine, String name, Dish[] dishes, int id) {
        this.cuisine = cuisine;
        this.name = name;
        this.dishes = dishes;
        this.imageResourceId = id;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getName() {
        return name;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public int getImageResourceId(){return imageResourceId;}

    public Restaurant[] getBajoranRestaurants(){return bajoranRestaurants;}
    public Restaurant[] getCardassianRestaurants(){return cardassianRestaurants;}
    public Restaurant[] getFerengiRestaurants(){return ferengiRestaurants;}
    public Restaurant[] getHumanRestaurants(){return humanRestaurants;}
    public Restaurant[] getKlingonRestaurants(){return klingonRestaurants;}
    public Restaurant[] getVulcanRestaurants(){return vulcanRestaurants;}
    @Override
    public String toString() {
        return this.name;
    }
}
