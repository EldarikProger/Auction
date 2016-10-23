package com.egar.auction.controller;

import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.model.Bid;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describe management guest
 */
public class ControlGuest implements UsersController {
    private AuctionDatabase database;

    /**
     * Create guest controller
     *
     * @param database
     */
    public ControlGuest(AuctionDatabase database) {
        this.database = database;
    }

    /**
     * Return list all goods by category
     *
     * @param category
     * @return list goods
     */
    @Override
    public List<Good> viewAllGoodsByCategory(Category category) {
        List<Good> list = new ArrayList<>();
        for (Good good : database.getAllGoods()) {
            if (good.getCategory() == category)
                list.add(good);
        }
        return list;
    }

    /**
     * Method return list all bets by good
     *
     * @param good
     * @return list bids
     */
    @Override
    public List<Bid> viewAllBidsByGood(Good good) {
        List<Bid> list = new ArrayList<>();
        for (Bid bid : database.getAllBids()) {
            if (bid.getGood().equals(good))
                list.add(bid);
        }
        return list;
    }

}
