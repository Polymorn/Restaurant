package com.restaurant.customer;

public class Customer {

    public static int count;
    public int id;
    public String name;
    public String phone;
    public String address;

    public Customer(String name, String phone, String address) {
        count++;
        id = count;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer " + "id='" + id + "', name='" + name + "', phone='" + phone + '\'' + ", address='" + address + "'";
    }
}
