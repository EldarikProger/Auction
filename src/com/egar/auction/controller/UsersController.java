package com.egar.auction.controller;

import com.egar.auction.model.Bid;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.List;


public interface UsersController extends Controller {

    List<Good> viewAllGoodsByCategory(Category category);

    List<Bid> viewAllBidsByGood(Good good);
}
