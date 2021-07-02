package com.restaurant.dishes;

public class Dish {

    public String name;
    public int price;
    public int id;

    public Dish(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.price = cost;
    }

    @Override
    public String toString() {
        return "Dish='" + name + "' cost='" + price + "'";
    }
}
