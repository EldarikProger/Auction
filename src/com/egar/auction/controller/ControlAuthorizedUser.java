package com.egar.auction.controller;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.*;

import java.util.ArrayList;
import java.util.List;


public class ControlAuthorizedUser implements UsersController {
    private AuthorizedUser user;
    private AuctionDatabase database;

    public ControlAuthorizedUser(AuctionDatabase database) {
        this.database = database;
    }

    public void connectToUser(String name, String password) throws UserNotFoundException, UserException {
        if (database.getAuthorizedUsers().size() == 0)
            throw new UserException("Пользователей не существует!");
        for (AuthorizedUser a : database.getAuthorizedUsers()) {
            if (name.equals(a.getName()) && password.equals(a.getPassword()))
                user = a;
        }
        if (user == null)
            throw new UserNotFoundException();
    }

    public AuthorizedUser getUser() {
        return user;
    }

    public void setUser(AuthorizedUser user) {
        this.user = user;
    }

    public void addGood(Category category, String name, String description, double minPrice, double maxPrice) {
        Good good = new Good(category, name, description, minPrice, maxPrice);
        user.addGood(good);
        database.addGood(good);
    }


    public void makeBet(double price, Good good) {
        Bid bid = new Bid(good, price, user);
        good.addBid(bid);
        user.addBid(bid);
        database.addBid(bid);
    }

    public void changeUserData(String name, String password) {
        user.setName(name);
        user.setPassword(password);
    }

    public List<Good> viewUserGoods() {
        return user.getMyGoods();
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

    public List<Bid> viewUserBids() {
        return user.getMyBids();
    }

    @Override
    public List<Bid> viewAllBidsByGood(Good good) {
        return good.getBidList();
    }

}
