package com.egar.auction.client.console.userConsole;


import com.egar.auction.exceptions.DistanceException;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.PriceService;
import com.egar.auction.model.Purchase;
import com.egar.auction.model.requests.GetCommonPrice;
import com.egar.auction.model.requests.GetPriceAllServiceForPurchase;
import com.egar.auction.model.requests.SetDeliveryServiceToPurchase;
import com.egar.auction.model.requests.ViewListPurchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;


public class ActionConsoleUserPurchase {

    private AuthorizedUser myUser;
    private BufferedReader br;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ActionConsoleUserPurchase(AuthorizedUser myUser, BufferedReader br, ObjectInputStream in,
                                     ObjectOutputStream out) {
        this.myUser = myUser;
        this.br = br;
        this.in = in;
        this.out = out;
    }

    public void viewListPurchase() {
        try {
            out.writeObject(new ViewListPurchase(myUser));
            List list = (List) in.readObject();
            printList(list);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void installDeliveryService() {
        try {
            out.writeObject(new ViewListPurchase(myUser));
            List listOfPurchase = (List) in.readObject();
            Purchase purchase = selectPurchase(listOfPurchase);
            out.writeObject(new GetPriceAllServiceForPurchase(myUser, purchase));
            Object object = in.readObject();
            if(object instanceof DistanceException)
                throw (DistanceException)object;
            else {
                List listOfPriseService = (List) object;
                printList(listOfPriseService);
                PriceService priceService = selectService(listOfPriseService);
                out.writeObject(new SetDeliveryServiceToPurchase(purchase, priceService.getService(),
                        Double.parseDouble(priceService.getPrice())));
            }
        } catch (UserException | ClassNotFoundException | IOException | DistanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCommonPricePurchase() {
        try {
            out.writeObject(new GetCommonPrice(myUser));
            String res = (String) in.readObject();
            System.out.println(res);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
                } catch (NumberFormatException e) {
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
            if (j <= 0 || j > i - 1)
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

