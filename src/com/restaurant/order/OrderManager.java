package com.restaurant.order;

import com.restaurant.customer.Customer;
import com.restaurant.dishes.Dish;
import com.restaurant.ui.ConsoleColors;

import java.util.Objects;

public class OrderManager {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Order[] orders = new Order[INIT_SIZE];
    private int pointer = 0;

    public void add(Dish dish, Customer customer) {
        if (pointer == orders.length - 1)
            resize(orders.length * 2);
        orders[pointer++] = new Order(dish, customer);
    }

    public Order get(int index) {
        return orders[index];
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            orders[i] = orders[i + 1];
        orders[pointer] = null;
        pointer--;
        if (orders.length > INIT_SIZE && pointer < orders.length / CUT_RATE)
            resize(orders.length / 2);
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Order[] newOrders = new Order[newLength];
        System.arraycopy(orders, 0, newOrders, 0, pointer);
        orders = newOrders;
    }

    public void createOrder(Dish dish, Customer customer) {
        add(dish, customer);
        System.out.println(ConsoleColors.ANSI_BLUE + "New order created: " + ConsoleColors.ANSI_RESET + this.get(pointer - 1).toString());
    }

    public Order getByCost(int cost) {
        for (Order order : orders) {
            if (!Objects.isNull(order) && cost == order.cost) {
                return order;
            }
        }
        System.out.println(ConsoleColors.ANSI_BLUE + "Order not found" + ConsoleColors.ANSI_RESET);
        return null;
    }

    public Order getByStatus(Enum e) {
        for (Order order : orders) {
            if (!Objects.isNull(order) && e.equals(order.orderStates)) {
                return order;
            }
        }
        return null;
    }

    public Order getById(int id) {
        for (Order order : orders) {
            if (!Objects.isNull(order) && id == order.id) {
                return order;
            }
        }
        System.out.println(ConsoleColors.ANSI_BLUE + "Order not found" + ConsoleColors.ANSI_RESET);
        return null;
    }

    public boolean compare(Customer customer, Dish dish) {
        for (Order order : orders) {
            if (!Objects.isNull(order) && order.customer.name.equals(customer.name) && order.customer.phone.equals(customer.phone) && order.customer.address.equals(customer.address) && order.dish.equals(dish)) {
                return true;
            }
        }
        return false;
    }
}
