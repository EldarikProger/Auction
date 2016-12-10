package com.egar.auction.controllers;

import com.egar.auction.model.*;
import com.egar.auction.storage.AuctionDatabase;

import java.util.*;

/**
 * Class describe manage user purchase
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class PurchaseController {

    private AuctionDatabase database;

    public PurchaseController(AuctionDatabase database) {
        this.database = database;
    }

    public List<Purchase> getTheGoodsPurchased(AuthorizedUser user) {
        List<Bid> list;
        for (Good good : database.getAllGoods()) { //идем по всем товарам
            if (good.isGoodSold()) { //если товар продан
                list = winBidsByGood(good); //все выигрышные ставки по товару
                for (Bid bid : list) { //идем по выйигрышным ставкам
                    boolean a = bid.getBuyer().equals(user);
                    boolean b = !betIsPurchases(bid); //если ставка не отслеживается как покупка
                    if (a && b) {
                        database.getPurchases().add(new Purchase(user, good, null, bid));//добавляем в покупки
                    }
                }
            }
        }

        List<Purchase> purchaseList = new ArrayList<>();
        for (Purchase purchase : database.getPurchases()){
            if (purchase.getBuyer().equals(user))
                purchaseList.add(purchase);
        }
        return purchaseList;
    }

    private boolean betIsPurchases(Bid myBet) { //ставка отслеживается как покупка
        for (Purchase purchase : database.getPurchases()) {
            if (purchase.getBidByGood().equals(myBet))
                return true;
        }
        return false;
    }

    private List<Bid> winBidsByGood(Good good) {
        List<Bid> list = new ArrayList<>();

        for (Bid bid : database.getAllBids()) { //все ставки по данному товару
            if (bid.getGood().equals(good)) {
                list.add(bid);
            }
        }

        Collections.sort(list, new Comparator<Bid>() { //сортировка листа
            @Override
            public int compare(Bid o1, Bid o2) {
                if (o1.getPrice() < o2.getPrice())
                    return 1;
                else
                    return -1;
            }
        });
        List<Bid> list1 = new ArrayList<>();

        if (good.getCount() >= list.size())
            return list;

        for (int count = 0; count < good.getCount(); count++) {
            list1.add(list.get(count));
        }

        return list1;
    }

    public String getCommonPriceByGood(AuthorizedUser user) {
        StringBuilder price = new StringBuilder();
        double sum = 0;
        for (Purchase purchase : database.getPurchases()) {
            if (!purchase.isDelivered() && purchase.getBuyer().equals(user)) {
                price.append("(");
                price.append("1");
                price.append("*");
                price.append(purchase.getBidByGood().getPrice());
                price.append("+");
                price.append(purchase.getPriceDelivery());
                price.append(")+");
                sum += purchase.getGood().getCount() * purchase.getBidByGood().getPrice() + purchase.getPriceDelivery();
            }
        }
        if (!price.toString().equals("")) {
            price.deleteCharAt(price.length() - 1);
            price.append("=");
            price.append(sum);
            return price.toString();
        } else {
            return "У вас нет покупок!";
        }
    }

    public void setDeliveryServiceToPurchase(Purchase purchase, DeliveryService deliveryService, double price) {
        purchase.setService(deliveryService);
        purchase.setPriceDelivery(price);
    }
}
