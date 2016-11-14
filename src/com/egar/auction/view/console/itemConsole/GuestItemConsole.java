package com.egar.auction.view.console.itemConsole;


import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.model.Guest;
import com.egar.auction.view.console.actionConsole.GuestActionConsole;

import java.util.Scanner;

/**
 * GuestItemConsole is the guest presentation
 *
 * @version 1.1
 * @author Eldar Ziatdinov
 */
public class GuestItemConsole {

    private Scanner scanner;
    private GuestActionConsole actionConsole;
    private Guest guest;

    /**
     * Create item and action console for guest
     *
     * @param guestController manage controller for guest
     * @param scanner to input data
     */
    public GuestItemConsole(GuestController guestController, Scanner scanner) {
        this.scanner = scanner;
        actionConsole = new GuestActionConsole(guestController, scanner);
    }

    /**
     * Method show view guest item console
     */
    public void show() {
        connect();
        System.out.println();
        System.out.println("Гость " + guest.getName());
        boolean flag = true;
        while (flag) {
            switch (menuGuest()) {
                case 1:
                    actionConsole.viewAllGoodsByCategory();
                    break;
                case 2:
                    actionConsole.viewAllBidsByGood();
                    break;
                case 3:
                    guest = null;
                    flag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }
    }

    private void connect(){
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        guest = new Guest(name);
    }

    private int menuGuest(){
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список товаров по категории");
        System.out.println("2) Посмотреть список всех ставок по товару");
        System.out.println("3) Выход");
        return scanner.nextInt();
    }

}
