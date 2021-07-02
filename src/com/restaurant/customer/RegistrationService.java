package com.restaurant.customer;

public class RegistrationService implements RegistrationInterface{

    private CustomerManager customerManager = new CustomerManager();

    @Override
    public void register(String name, String phone, String address) {
        if (!customerManager.compare(name, phone, address))
        customerManager.register(name, phone, address);
        else {
            System.out.println("This customer already exists!");
        }
    }

    @Override
    public Customer getById(int id) {
        return customerManager.getById(id);
    }

    @Override
    public Customer find(String name, String phone, String address) {
        return customerManager.find(name, phone, address);
    }
}
