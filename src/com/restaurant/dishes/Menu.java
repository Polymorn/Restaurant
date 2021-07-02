package com.restaurant.dishes;

import com.restaurant.ui.ConsoleColors;

public class Menu {

    public Menu() {
        getMenuList();
    }

    public Dish[] dishes = new Dish[7];

    public Dish[] getMenuList() {
        dishes[0] = new Dish(1, "Square potato", 64);
        dishes[1] = new Dish(2, "Beer marshmallows", 99);
        dishes[2] = new Dish(3, "Polygonal pizza", 128);
        dishes[3] = new Dish(4, "Fried nails", 77);
        dishes[4] = new Dish(5, "Meat explosion", 666);
        dishes[5] = new Dish(6, "Juicy juice", 69);
        dishes[6] = new Dish(7, "Stoned soup", 420);
        return dishes;
    }

    public void show() {
        int i = 1;
        for (Dish dish : this.getMenuList()) {
            System.out.println(ConsoleColors.ANSI_BLUE + i++ + " - " + dish.name + ConsoleColors.ANSI_RESET);
        }
    }

    public Dish get(String name) {
        for (Dish dish : dishes) {
            if (name.equals(dish.name)) {
                return dish;
            }
        }
        System.out.println("Dish not found");
        return null;
    }

    public Dish get(int id) {
        for (Dish dish : dishes) {
            if (id == dish.id) {
                return dish;
            }
        }
        System.out.println("Dish not found");
        return null;
    }
}
