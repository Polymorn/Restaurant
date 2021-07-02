package com.restaurant.kitchen;

import com.restaurant.order.Order;
import com.restaurant.order.OrderStates;
import com.restaurant.ui.ConsoleColors;

public class Kitchen implements KitchenService {
    @Override
    public void cook(Order order) {
        order.orderStates = OrderStates.COOKING;

        System.out.println(order + ConsoleColors.ANSI_BLUE + " is cooking" + ConsoleColors.ANSI_RESET);

        order.orderStates = OrderStates.COOKED;

        System.out.println(order + ConsoleColors.ANSI_BLUE + " is cooked" + ConsoleColors.ANSI_RESET);
    }
}
