package com.restaurant.delivery;

import com.restaurant.customer.Customer;
import com.restaurant.order.Order;

public interface DeliveryService {
    void deliver(Order order, Customer customer);
}
