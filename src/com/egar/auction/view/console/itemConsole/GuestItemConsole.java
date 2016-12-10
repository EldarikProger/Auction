package com.egar.auction.view.console.itemConsole;


import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.model.Guest;
import com.egar.auction.view.console.actionConsole.GuestActionConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * GuestItemConsole is the guest presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class GuestItemConsole {

    private BufferedReader br;
    private GuestActionConsole actionConsole;
    private Guest guest;

    /**
     * Create item and action console for guest
     *
     * @param guestController manage controller for guest
     * @param br              to input data
     */
    public GuestItemConsole(GuestController guestController, BufferedReader br) {
        this.br = br;
        actionConsole = new GuestActionConsole(guestController, br);
    }

    /**
     * Method show view guest item console
     */
    public void show() {
        try {
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
                        actionConsole = null;
                        flag = false;
                        break;
                    default:
                        System.out.println("Вы выбрали несуществующий вариант!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        guest = new Guest(name);
    }

    private int menuGuest() throws IOException {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список товаров по категории");
        System.out.println("2) Посмотреть список всех ставок по товару");
        System.out.println("3) Выход");
        int a;
        while (true) {
            try {
                a = Integer.parseInt(br.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Вы ввели не число, введите число заново");
            }
        }
        return a;
    }

}
