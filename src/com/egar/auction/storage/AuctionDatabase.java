package com.egar.auction.storage;

import com.egar.auction.model.Admin;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Bid;
import com.egar.auction.model.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Class is the storage.
 * AuctionDatabase save references on the all objects
 */
public class AuctionDatabase {
    private List<AuthorizedUser> authorizedUsers;
    private List<Admin> admins;
    private List<Bid> allBids;
    private List<Good> allGoods;

    /**
     * Create database
     */
    public AuctionDatabase() {
        allBids = new ArrayList<>();
        admins = new ArrayList<>();
        authorizedUsers = new ArrayList<>();
        allGoods = new ArrayList<>();
    }

    /**
     * Add user
     *
     * @param user
     */
    public void addAuthorizedUser(AuthorizedUser user) {
        authorizedUsers.add(user);
    }

    /**
     * Add admin
     *
     * @param admin
     */
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    /**
     * Add bid
     *
     * @param bid
     */
    public void addBid(Bid bid) {
        allBids.add(bid);
    }

    /**
     * Add good
     *
     * @param good
     */
    public void addGood(Good good) {
        allGoods.add(good);
    }

    /**
     * Return list all users
     *
     * @return
     */
    public List<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    /**
     * Return list all admins
     *
     * @return
     */
    public List<Admin> getAdmins() {
        return admins;
    }

    /**
     * Return list all bids
     *
     * @return
     */
    public List<Bid> getAllBids() {
        return allBids;
    }

    /**
     * Return list all goods
     *
     * @return
     */
    public List<Good> getAllGoods() {
        return allGoods;
    }
}
