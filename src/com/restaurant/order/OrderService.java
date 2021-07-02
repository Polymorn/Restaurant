package com.restaurant.order;

import com.restaurant.customer.Customer;
import com.restaurant.dishes.Dish;

public class OrderService implements OrderInterface{

    OrderManager orderManager = new OrderManager();
    @Override
    public void createOrder(Dish dish, Customer customer){

        if (!orderManager.compare(customer, dish))
            orderManager.createOrder(dish, customer);
        else {
            System.out.println("This order already exists!");
        }
    }

    @Override
    public Order getById(int id){
        return orderManager.getById(id);
    }

    @Override
    public Order getByStatus(Enum e){
        return orderManager.getByStatus(e);
    }

}
