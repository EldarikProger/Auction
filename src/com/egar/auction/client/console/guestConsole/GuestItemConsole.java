package com.egar.auction.client.console.guestConsole;


import com.egar.auction.model.Guest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
     * @param guest
     * @param in
     * @param out
     * @param br    to input data
     */
    public GuestItemConsole(BufferedReader br, Guest guest, ObjectOutputStream out, ObjectInputStream in) {
        this.br = br;
        actionConsole = new GuestActionConsole(br, out, in);
    }

    /**
     * Method show view guest item console
     */
    public void show() {
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
                    actionConsole.exit();
                    flag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }

    }

    private int menuGuest() {
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
