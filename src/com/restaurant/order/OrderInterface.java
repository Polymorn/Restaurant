package com.restaurant.order;

import com.restaurant.customer.Customer;
import com.restaurant.dishes.Dish;

public interface OrderInterface {
    void createOrder(Dish dish, Customer customer);

    Order getById(int id);

    Order getByStatus(Enum e);
}
