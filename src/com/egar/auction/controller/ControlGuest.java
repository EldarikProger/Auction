package com.egar.auction.controller;

import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.model.Bid;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.ArrayList;
import java.util.List;


public class ControlGuest implements UsersController{
    private AuctionDatabase database;

    public ControlGuest(AuctionDatabase database) {
        this.database = database;
    }

    @Override
    public List<Good> viewAllGoodsByCategory(Category category) {
        List<Good> list = new ArrayList<>();
        for (Good good : database.getAllGoods()) {
            if (good.getCategory() == category)
                list.add(good);
        }
        return list;
    }

    @Override
    public List<Bid> viewAllBidsByGood(Good good){
        return good.getBidList();
    }

}
