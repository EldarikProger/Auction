package com.egar.auction.controller;

import com.egar.auction.model.Bid;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.List;

/**
 * Describes of all user controllers
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public interface UsersController extends Controller {

    /**
     * Return list all goods by category
     *
     * @param category category good at which selecting
     * @return list good
     */
    List<Good> viewAllGoodsByCategory(Category category);

    /**
     * Method return list all bets by good
     *
     * @param good category good at which selecting
     * @return list bid
     */
    List<Bid> viewAllBidsByGood(Good good);
}
