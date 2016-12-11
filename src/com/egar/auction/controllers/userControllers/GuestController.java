package com.egar.auction.controllers.userControllers;

import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.model.Bid;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describe management guest
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class GuestController implements UsersController {

    private AuctionDatabase database;

    /**
     * Create guest controllers
     *
     * @param database
     */
    public GuestController(AuctionDatabase database) {
        this.database = database;
    }

    /**
     * Return list all goods by category
     *
     * @param category category good at which selecting
     * @return list goods
     */
    @Override
    public List<Good> listAllGoodsByCategory(Category category) {
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
     * @param good good at which selecting
     * @return list bids
     */
    @Override
    public List<Bid> listAllBidsByGood(Good good) {
        List<Bid> list = new ArrayList<>();
        for (Bid bid : database.getAllBids()) {
            if (bid.getGood().equals(good))
                list.add(bid);
        }
        return list;
    }

    /**
     * Method return list Category
     *
     * @return list Category
     */
    public List<Category> getListCategory(){
        return database.getCategories();
    }

}
