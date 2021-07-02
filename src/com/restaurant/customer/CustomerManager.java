package com.restaurant.customer;

import com.restaurant.ui.ConsoleColors;

import java.util.Objects;

public class CustomerManager {

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Customer[] customers = new Customer[INIT_SIZE];
    private int pointer = 0;

    public void add(String name, String phone, String address) {
        if (pointer == customers.length - 1)
            resize(customers.length * 2);
        customers[pointer++] = new Customer(name, phone, address);
    }

    public boolean compare(String name, String phone, String address) {
        for (Customer customer : customers) {
            if (!Objects.isNull(customer) && customer.name.equals(name) && customer.phone.equals(phone) && customer.address.equals(address)) {
                return true;
            }
        }
        return false;
    }

    public Customer get(int index) {
        return customers[index];
    }

    public Customer getByName(String name) {
        for (Customer customer : customers) {
            if (!Objects.isNull(customer) && name.equals(customer.name)) {
                return customer;
            }
        }
        System.out.println(ConsoleColors.ANSI_BLUE + "Customer not found" + ConsoleColors.ANSI_RESET);
        return null;
    }

    public Customer getById(int id) {
        for (Customer customer : customers) {
            if (!Objects.isNull(customer) && id == customer.id) {
                return customer;
            }
        }
        System.out.println(ConsoleColors.ANSI_BLUE + "Customer not found" + ConsoleColors.ANSI_RESET);
        return null;
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            customers[i] = customers[i + 1];
        customers[pointer] = null;
        pointer--;
        if (customers.length > INIT_SIZE && pointer < customers.length / CUT_RATE)
            resize(customers.length / 2);
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Customer[] newCustomers = new Customer[newLength];
        System.arraycopy(customers, 0, newCustomers, 0, pointer);
        customers = newCustomers;
    }

    public void register(String name, String phone, String address) {
        this.add(name, phone, address);
        System.out.println(ConsoleColors.ANSI_BLUE + "New customer created: " + ConsoleColors.ANSI_RESET + this.get(pointer - 1).toString());
    }

    public Customer find(String name, String phone, String address) {
        for (Customer customer : customers) {
            if (!Objects.isNull(customer) && name.equals(customer.name) && phone.equals(customer.phone) && address.equals(customer.address)) {
                return customer;
            }
        }
        System.out.println(ConsoleColors.ANSI_BLUE + "Customer not found" + ConsoleColors.ANSI_RESET);
        return null;
    }
}
