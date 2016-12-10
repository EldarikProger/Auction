package com.egar.auction.view.console.itemConsole;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.view.console.actionConsole.ActionConsoleUserPurchase;

import java.util.Scanner;

public class ItemConsoleUserPurchase {

    private AuthorizedUser myUser;
    private Scanner scanner;
    private PurchaseController purchaseController;
    private ActionConsoleUserPurchase actionConsole;

    public ItemConsoleUserPurchase(AuthorizedUser myUser, Scanner scanner,
                                   PurchaseController purchaseController, DeliveryServiceController deliveryServiceController) {
        this.myUser = myUser;
        this.scanner = scanner;
        this.purchaseController = purchaseController;
        this.actionConsole = new ActionConsoleUserPurchase(purchaseController, myUser, scanner, deliveryServiceController);
    }

    public void setMyUser(AuthorizedUser myUser) {
        this.myUser = myUser;
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
        return scanner.nextInt();
    }

}
