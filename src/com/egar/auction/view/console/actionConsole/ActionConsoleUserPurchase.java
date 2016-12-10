package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.DeliveryService;
import com.egar.auction.model.Purchase;

import java.util.List;
import java.util.Scanner;

public class ActionConsoleUserPurchase {

    private PurchaseController purchaseController;
    private DeliveryServiceController deliveryServiceController;
    AuthorizedUser myUser;
    Scanner scanner;

    public ActionConsoleUserPurchase(PurchaseController purchaseController, AuthorizedUser myUser,
                                     Scanner scanner, DeliveryServiceController deliveryServiceController) {
        this.purchaseController = purchaseController;
        this.myUser = myUser;
        this.scanner = scanner;
        this.deliveryServiceController = deliveryServiceController;
    }

    public void viewListPurchase() {
        printList(purchaseController.getTheGoodsPurchased(myUser));
    }

    public void installDeliveryService() {
        try {
            Purchase purchase = selectPurchase(purchaseController.getTheGoodsPurchased(myUser));
            printList(deliveryServiceController.getPriceAllServiceForPurchase(purchase, myUser));
            DeliveryService service = selectService(deliveryServiceController.getListDeliveryService());
            purchaseController.setDeliveryServiceToPurchase(purchase, service);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCommonPricePurchase() {
        System.out.println(purchaseController.getCommonPriceByGood(myUser));
    }

    private Purchase selectPurchase(List<Purchase> list) throws UserException {
        System.out.println();
        if (list.size() != 0) {
            System.out.println("Выберите покупку:");
            int i = 1;
            for (Purchase c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j = scanner.nextInt();
            if (j <= 0 || j > list.size())
                throw new UserException("Вы выбрали не существующую покупку!");
            return list.get(j - 1);
        } else
            throw new UserException("Список покупок пуст!");
    }

    private DeliveryService selectService(List<DeliveryService> list) throws UserException {
        System.out.println();
        if (list.size() != 0) {
            System.out.println("Выберите сервис доставки:");
            int i = 1;
            for (DeliveryService c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j = scanner.nextInt();
            if (j <= 0 || j > list.size())
                throw new UserException("Вы выбрали не существующий сервис!");
            return list.get(j - 1);
        } else
            throw new UserException("Список сервисов пуст!");
    }

    private void printList(List list) {
        System.out.println();
        if (list.size() == 0)
            System.out.println("Список пуст!");
        int i = 1;
        for (Object obj : list) {
            System.out.println((i++) + ") " + obj.toString());
        }
    }
}
