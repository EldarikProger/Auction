package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.exceptions.DistanceException;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.DeliveryService;
import com.egar.auction.model.PriceService;
import com.egar.auction.model.Purchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ActionConsoleUserPurchase {

    private PurchaseController purchaseController;
    private DeliveryServiceController deliveryServiceController;
    private AuthorizedUser myUser;
    private BufferedReader br;

    public void setMyUser(AuthorizedUser myUser) {
        this.myUser = myUser;
    }

    public ActionConsoleUserPurchase(PurchaseController purchaseController, AuthorizedUser myUser,
                                     BufferedReader br, DeliveryServiceController deliveryServiceController) {
        this.purchaseController = purchaseController;
        this.myUser = myUser;
        this.br = br;
        this.deliveryServiceController = deliveryServiceController;
    }

    public void viewListPurchase() {
        printList(purchaseController.getTheGoodsPurchased(myUser));
    }

    public void installDeliveryService() {
        try {
            Purchase purchase = selectPurchase(purchaseController.getTheGoodsPurchased(myUser));
            List<PriceService> list = deliveryServiceController.getPriceAllServiceForPurchase(purchase, myUser);
            printList(list);
            PriceService priceService = selectService(list);
            purchaseController.setDeliveryServiceToPurchase(purchase, priceService.getService(),
                    Double.parseDouble(priceService.getPrice()));
        } catch (UserException | DistanceException e) {
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
            int j;
            while (true) {
                try {
                    j = Integer.parseInt(br.readLine());
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Вы ввели не число, введите число заново");
                }
            }
            if (j <= 0 || j > list.size())
                throw new UserException("Вы выбрали не существующую покупку!");
            return list.get(j - 1);
        } else
            throw new UserException("Список покупок пуст!");
    }

    private PriceService selectService(List<PriceService> list) throws UserException {
        System.out.println();
        if (list.size() != 0) {
            System.out.println("Выберите сервис доставки:");
            int i = 1;
            Iterator<PriceService> iter = list.iterator();
            while (iter.hasNext()) { //удаление ненужных сервисов
                PriceService s = iter.next();
                try {
                    Double.parseDouble(s.getPrice());
                } catch (NumberFormatException e){
                    iter.remove();
                }

            }
            for (PriceService c : list) { //печать сервисов
                    System.out.println((i++) + ") " + c.toString());
            }
            int j;
            while (true) {
                try {
                    j = Integer.parseInt(br.readLine());
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Вы ввели не число, введите число заново");
                }
            }
            if (j <= 0 || j > i-1)
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
