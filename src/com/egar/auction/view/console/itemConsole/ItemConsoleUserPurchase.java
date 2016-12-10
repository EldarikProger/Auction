package com.egar.auction.view.console.itemConsole;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.view.console.actionConsole.ActionConsoleUserPurchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ItemConsoleUserPurchase {

    private AuthorizedUser myUser;
    private BufferedReader br;
    private PurchaseController purchaseController;
    private ActionConsoleUserPurchase actionConsole;

    public ItemConsoleUserPurchase(AuthorizedUser myUser, BufferedReader br,
                                   PurchaseController purchaseController, DeliveryServiceController deliveryServiceController) {
        this.myUser = myUser;
        this.br = br;
        this.purchaseController = purchaseController;
        this.actionConsole = new ActionConsoleUserPurchase(purchaseController, myUser, br, deliveryServiceController);
    }

    public void setMyUser(AuthorizedUser myUser) {
        this.myUser = myUser;
        actionConsole.setMyUser(myUser);
    }

    public void show() {
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
