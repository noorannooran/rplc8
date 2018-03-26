package com.example.gb.a1100695733;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class Order implements Serializable {
    private Customer customer;
    private ArrayList<Dish> selectedDishes;
    private Restaurant restaurant;
    private double totalPrice;

    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public Order(Restaurant restaurant) {
        this.restaurant = restaurant;
        selectedDishes = new ArrayList<Dish>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Dish> getSelectedDishes() {
        return selectedDishes;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSelectedDishes(ArrayList<Dish> selectedDishes) {
        this.selectedDishes = selectedDishes;
    }

    public void addSelectedDish(Dish dish) {
        selectedDishes.add(dish);
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double calculateTotal() {
        double total = 0;
        for (Dish dish : selectedDishes)
            total += dish.getPrice();
        return total;
    }

    public String selectedDishesString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Dish> dishes = this.selectedDishes;
        for (Dish dish : dishes) {
            sb.append(dish.getName());
            sb.append(" ");
            sb.append(dish.getPrice());
            sb.append(" credits \n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return customer + "\n" +
                restaurant + "\n" +
                this.selectedDishesString() +
                "Total Price: " + totalPrice + " credits \n";
    }
}