package com.restaurant.delivery;

import com.restaurant.customer.Customer;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStates;
import com.restaurant.ui.ConsoleColors;

public class Delivery implements DeliveryService {

    @Override
    public void deliver(Order order, Customer customer) {
        order.orderStates = OrderStates.DELIVERY;
        System.out.println(order + ConsoleColors.ANSI_BLUE
                + " is delivering to " + ConsoleColors.ANSI_RESET + customer.name);

        order.orderStates = OrderStates.DELIVERED;
        System.out.println(order + ConsoleColors.ANSI_BLUE
                + " is delivered to " + ConsoleColors.ANSI_RESET + customer.name);
        System.out.println(ConsoleColors.ANSI_CYAN + "Bon Appetit!" + ConsoleColors.ANSI_RESET);
    }
}
