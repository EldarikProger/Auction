package com.egar.auction.client.console.userConsole;

import com.egar.auction.model.AuthorizedUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Item ConsoleUserPurchase is the user purchase presentation
 */
public class ItemConsoleUserPurchase {

    private AuthorizedUser myUser;
    private BufferedReader br;
    private ActionConsoleUserPurchase actionConsole;

    /**
     * Create ItemConsoleUserPurchase
     *
     * @param myUser
     * @param br
     * @param in
     * @param out
     */
    public ItemConsoleUserPurchase(AuthorizedUser myUser, BufferedReader br, ObjectInputStream in,
                                   ObjectOutputStream out) {
        this.myUser = myUser;
        this.br = br;
        this.actionConsole = new ActionConsoleUserPurchase(myUser, br, in, out);
    }

    /**
     * Method show view user item purchase console
     */
    public void show() {
        System.out.println();
        System.out.println("Пользователь " + myUser.getName() + ":");
        boolean nextRun = true;
        while (nextRun) {
            switch (menuPurchase()) {
                case 1:
                    actionConsole.viewListPurchase();
                    break;
                case 2:
                    actionConsole.installDeliveryService();
                    break;
                case 3:
                    actionConsole.getCommonPricePurchase();
                    break;
                case 4:
                    nextRun = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }

    }

    private int menuPurchase() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список моих покупок");
        System.out.println("2) Усановить сервис досавки для покупки");
        System.out.println("3) Расчет общей суммы покупок с учетом доставки");
        System.out.println("4) Выход");
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

