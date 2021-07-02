package com.restaurant;

import com.restaurant.customer.RegistrationInterface;
import com.restaurant.customer.RegistrationService;
import com.restaurant.delivery.Delivery;
import com.restaurant.delivery.DeliveryService;
import com.restaurant.dishes.Menu;
import com.restaurant.kitchen.Kitchen;
import com.restaurant.kitchen.KitchenService;
import com.restaurant.order.Order;
import com.restaurant.order.OrderInterface;
import com.restaurant.order.OrderService;
import com.restaurant.order.OrderStates;
import com.restaurant.ui.ConsoleColors;
import com.restaurant.ui.UserInterface;
import com.restaurant.ui.UserTerminal;

public class Restaurant {

    private RegistrationInterface registrationInterface = new RegistrationService();
    private OrderInterface orderInterface = new OrderService();
    private Menu menu = new Menu();
    private KitchenService kitchen = new Kitchen();
    private DeliveryService delivery = new Delivery();
    private UserInterface ui = new UserTerminal(registrationInterface, orderInterface, menu);

    public void serve() {

        registrationInterface.register("Vasya", "8-800-555-35-35", "Pushkeena street");
        registrationInterface.register("Vova", "8-911-412-12-31", "Kaka street");
        orderInterface.createOrder(menu.get(1), registrationInterface.getById(1));
        orderInterface.createOrder(menu.get(5), registrationInterface.getById(2));
        orderInterface.createOrder(menu.get(2), registrationInterface.getById(1));

        routineCycle();
        ui.initialize();
        routineCycle();
    }

    // Если есть созданные заказы, отправляем их в производство!
    private void routineCycle() {
        while (orderInterface.getByStatus(OrderStates.CREATED) != null) {
            int idCycle = orderInterface.getByStatus(OrderStates.CREATED).id;
            int customerId = orderInterface.getByStatus(OrderStates.CREATED).customer.id;
            routine(idCycle, customerId);
        }
    }

    // Производство: отправляем заказ на кухню, затем доставляем его клиенту
    private void routine(int orderId, int customerId) {
        System.out.println(ConsoleColors.ANSI_WHITE + "=====================================================" + ConsoleColors.ANSI_RESET);
        kitchen.cook(orderInterface.getById(orderId));
        delivery.deliver(orderInterface.getById(orderId), registrationInterface.getById(customerId));
    }
}