package com.restaurant.customer;

public interface RegistrationInterface {
    void register(String name, String phone, String address);

    Customer getById(int id);

    Customer find(String name, String phone, String address);
}
