package com.restaurant.ui;

import com.restaurant.customer.RegistrationInterface;
import com.restaurant.dishes.Menu;
import com.restaurant.order.OrderInterface;

import java.util.Scanner;

public class UserTerminal implements UserInterface {

    private Scanner scanner;
    private String name, phoneNumber, address;
    private RegistrationInterface registrationInterface;
    private OrderInterface orderService;
    private Menu menu;

    public UserTerminal(RegistrationInterface registrationInterface, OrderInterface orderInterface, Menu menu) {
        this.scanner = new Scanner(System.in);
        this.registrationInterface = registrationInterface;
        this.orderService = orderInterface;
        this.menu = menu;
    }

    @Override
    public void initialize() {
        welcomeMsg();
        singUp();
        makeAnOrder();
    }

    @Override
    public void singUp() {
        System.out.println(ConsoleColors.ANSI_YELLOW + "## ENTER YOUR NAME ##" + ConsoleColors.ANSI_RESET);
        name = scanner.nextLine();

        System.out.println(ConsoleColors.ANSI_YELLOW + "## ENTER YOUR PHONE NUMBER ##" + ConsoleColors.ANSI_RESET);
        phoneNumber = scanner.nextLine();

        System.out.println(ConsoleColors.ANSI_YELLOW + "## ENTER YOUR ADDRESS ##" + ConsoleColors.ANSI_RESET);
        address = scanner.nextLine();

        registrationInterface.register(name, phoneNumber, address);
    }

    @Override
    public void makeAnOrder() {
        Menu menu = new Menu();
        int orderChoice = 1;
        System.out.println(ConsoleColors.ANSI_YELLOW + "## MAKE AN ORDER ##" + ConsoleColors.ANSI_RESET);
        menu.show();
        try {
            orderChoice = Integer.parseInt(scanner.nextLine());
            if (orderChoice > menu.getMenuList().length || orderChoice < 1) {
                System.out.println(ConsoleColors.ANSI_RED + "You entered a wrong dish number!" + ConsoleColors.ANSI_RESET);
                makeAnOrder();
            }
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColors.ANSI_RED + "You entered a wrong dish number!" + ConsoleColors.ANSI_RESET);
            System.out.println(ConsoleColors.ANSI_RED + "Look at menu list" + ConsoleColors.ANSI_RESET);
            makeAnOrder();
        }

        orderService.createOrder(menu.get(orderChoice), registrationInterface.find(name, phoneNumber, address));
    }

    public void welcomeMsg() {
        System.out.println(ConsoleColors.ANSI_WHITE + "=====================================================");
        System.out.println("=                                                   =");
        System.out.println("=                  W E L C O M E                    =");
        System.out.println("=                                                   =");
        System.out.println("=====================================================" + ConsoleColors.ANSI_RESET);

    }
}