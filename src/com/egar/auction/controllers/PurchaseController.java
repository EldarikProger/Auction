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

    public List<Purchase> getTheGoodsPurchased(AuthorizedUser user) {//check may be crate SaleController?
        List<Bid> list;
        for (Good good : database.getAllGoods()) {
            list = winBidsByGood(good); //все выигрышные ставки по товару
            for (Bid bid : list) {
                if (bid.getBuyer().equals(user)) {
                    database.getPurchases().add(new Purchase(user, good, null, bid));//check list goods
                }
            }
        }
        return database.getPurchases();
    }

    private List<Bid> winBidsByGood(Good good) {
        List<Bid> list = new ArrayList<>();

        for (Bid bid : database.getAllBids()) { //все ставки по данному товару
            if (bid.getGood().equals(good)) {
            }
            list.add(bid);
        }

        Collections.sort(list, new Comparator<Bid>() { //сортировка листа
            @Override
            public int compare(Bid o1, Bid o2) {
                if (o1.getPrice() <= o2.getPrice())
                    return -1;
                else
                    return 1;
            }
        });
        List<Bid> list1 = new ArrayList<>();
        int count = good.getCount() - 1;
        if (good.getCount() >= list.size())
            count = list.size() - 1;
        for (; count >= 0; count--) {
            list1.add(list.get(count));
        }

        return list1;
    }

    public String getCommonPriceByGood(AuthorizedUser user) {
        StringBuffer price = new StringBuffer();
        double sum = 0;
        for (Purchase purchase : database.getPurchases()) {
            if (purchase.getBuyer().equals(user)) {
                price.append("(");
                price.append(purchase.getGood().getCount());
                price.append("*");
                price.append(purchase.getBidByGood().getPrice());
                price.append("+");
                price.append(purchase.getPriceDelivery());
                price.append(")+");
                sum += purchase.getGood().getCount() * purchase.getBidByGood().getPrice() + purchase.getPriceDelivery();
            }
        }
        if(!price.toString().equals(""))
            price.deleteCharAt(price.length()-1);
        price.append("=");
        price.append(sum);
        return price.toString();
    }
}
