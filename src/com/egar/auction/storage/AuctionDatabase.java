package com.egar.auction.storage;

import com.egar.auction.model.Admin;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Bid;
import com.egar.auction.model.Good;

import java.util.ArrayList;
import java.util.List;


public class AuctionDatabase {
    private List<AuthorizedUser> authorizedUsers;
    private List<Admin> admins;
    private List<Bid> allBids;
    private List<Good> allGoods;

    public AuctionDatabase() {
        allBids = new ArrayList<>();
        admins = new ArrayList<>();
        authorizedUsers = new ArrayList<>();
        allGoods = new ArrayList<>();
    }

    public void addAuthorizedUser(String name, String password) {
        authorizedUsers.add(new AuthorizedUser(name, password));
    }

    public void addAdmin(String name, String password) {
        admins.add(new Admin(name, password));
    }

    public void addBid(Bid bid) {
        allBids.add(bid);
    }

    public void addGood(Good good) {
        allGoods.add(good);
    }

    public List<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Bid> getAllBids() {
        return allBids;
    }

    public List<Good> getAllGoods() {
        return allGoods;
    }
}
