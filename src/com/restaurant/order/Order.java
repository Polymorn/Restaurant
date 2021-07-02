package com.restaurant.order;

import com.restaurant.customer.Customer;
import com.restaurant.dishes.Dish;

public class Order {

    public static int counter;
    public int id;
    public int cost;
    public Dish dish;
    public Customer customer;
    public OrderStates orderStates = OrderStates.CREATED;

    public Order(Dish dish, Customer customer) {
        counter++;
        this.id = counter;
        this.dish = dish;
        this.customer = customer;
        this.cost = dish.price;
        this.orderStates = OrderStates.CREATED;
    }

    @Override
    public String toString() {
        return "Order='" + id + "' dish='" + dish.name + "' customer='" + customer.name + "' status='" + orderStates + "' cost='" + cost + "'";
    }
}
