package com.egar.auction.controllers;

import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Bid;
import com.egar.auction.model.Good;
import com.egar.auction.model.Purchase;
import com.egar.auction.storage.AuctionDatabase;

import java.util.*;

/**
 * Class describe manage user purchase
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class PurchaseController {

    private AuthorizedUser user;
    private AuctionDatabase database;

    public List<Purchase> getTheGoodsPurchased() {//check may be crate SaleController?
        List<Bid> list;
        List<Purchase> purchaseList = new ArrayList<>();

        for (Good good : database.getAllGoods()) {
            list = winBidsByGood(good);
            for(Bid bid : list){
                if(bid.getBuyer().equals(user)){
                    purchaseList.add(new Purchase(user,good,null));//check list goods
                }
            }
        }
        return null;
    }

    private List<Bid> winBidsByGood(Good good) {
        List<Bid> list = new ArrayList<>();

        for (Bid bid : database.getAllBids()) {
            if(bid.getGood().equals(good)){
                list.add(bid);
            }
        }

        Collections.sort(list, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                if(o1.getPrice()<=o2.getPrice())
                    return 1;
                else
                    return -1;
            }
        });

        for (int i = 0,count = good.getCount(); i< list.size(); i++ , count--){
            if(count>0) {
                continue;
            }
            else{
                list.remove(i);
            }
        }

        return list;
    }

    public String getCommonPriceByGood() {
        return "";
    }
}
