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
 *
 * @author Eldar Ziatdinov
 * @version 1.0
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
     * @param user AuthorizedUser which addition in the storage
     */
    public void addAuthorizedUser(AuthorizedUser user) {
        authorizedUsers.add(user);
    }

    /**
     * Add admin
     *
     * @param admin Admin which addition in the storage
     */
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    /**
     * Add bid
     *
     * @param bid Bid which addition in the storage
     */
    public void addBid(Bid bid) {
        allBids.add(bid);
    }

    /**
     * Add good
     *
     * @param good Good which addition in the storage
     */
    public void addGood(Good good) {
        allGoods.add(good);
    }

    /**
     * Return list all users
     *
     * @return list all AuthorizedUsers
     */
    public List<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    /**
     * Return list all admins
     *
     * @return list all Admins
     */
    public List<Admin> getAdmins() {
        return admins;
    }

    /**
     * Return list all bids
     *
     * @return list all Bids
     */
    public List<Bid> getAllBids() {
        return allBids;
    }

    /**
     * Return list all goods
     *
     * @return list all Goods
     */
    public List<Good> getAllGoods() {
        return allGoods;
    }
}
