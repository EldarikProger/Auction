package com.egar.auction.controller;

import com.egar.auction.model.*;

import java.util.ArrayList;
import java.util.List;


public class ControlAuthorizedUser implements Controller {
    private AuthorizedUser user;
    private AuctionDatabase database;

    public ControlAuthorizedUser(AuctionDatabase database) {
        this.database = database;
    }

    public AuthorizedUser getUser() {
        return user;
    }

    public void setUser(AuthorizedUser user) {
        this.user = user;
    }

    public void addGood(Good good) {
        user.getMyGoods().add(good);
    }

    public void putBid(Bid bid) {
        user.getMyBids().add(bid);
    }

    public void makeBet(double price, Bid bid) {
        bid.setCurrentPrice(price);
        bid.setCurrentBuyer(user);
    }

    public void changeUserData(String name, String password) {
        user.setName(name);
        user.setPassword(password);
    }

    public List<Good> viewUserGoods() {
        return user.getMyGoods();
    }

    public List<Good> viewUserGoodsByCategory(Category category) {
        List<Good> list = new ArrayList<>();
        for (Good good : user.getMyGoods()) {
            if (good.getCategory() == category)
                list.add(good);
        }
        return list;
    }

    public List<Bid> viewUserBids() {
        return user.getMyBids();
    }

    public List<Bid> viewAllBids() {
        return database.getAllBids();
    }

}
