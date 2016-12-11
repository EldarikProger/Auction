package com.egar.auction.storage;

import com.egar.auction.model.*;

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
    private List<Category> categories;

    private static AuctionDatabase instanceDB;

    public static AuctionDatabase getInstance() {
        if (instanceDB == null) {
            instanceDB = new AuctionDatabase();
            Category category = new Category("CLOTHING");
            instanceDB.addCategory(category);
            category = new Category("SHOES");
            instanceDB.addCategory(category);
            category = new Category("TELEPHONE");
            instanceDB.addCategory(category);
            category = new Category("AUTO");
            instanceDB.addCategory(category);
            category = new Category("JEWELRY");
            instanceDB.addCategory(category);
            category = new Category("WATCH");
            instanceDB.addCategory(category);
            category = new Category("COMPUTER_EQUIPMENT");
            instanceDB.addCategory(category);
            category = new Category("ELECTRONICS");
            instanceDB.addCategory(category);
            category = new Category("SPORTS_WEAR");
            instanceDB.addCategory(category);
            category = new Category("BUILDING_TOOLS");
            instanceDB.addCategory(category);
            category = new Category("FURNITURE");
            instanceDB.addCategory(category);
            category = new Category("FOOD");
            instanceDB.addCategory(category);
            category = new Category("MUSICAL_INSTRUMENTS");
            instanceDB.addCategory(category);
        }
        return instanceDB;
    }

    /**
     * Create database
     */
    private AuctionDatabase() {
        allBids = new ArrayList<>();
        admins = new ArrayList<>();
        authorizedUsers = new ArrayList<>();
        allGoods = new ArrayList<>();
        categories = new ArrayList<>();
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
     * Add category
     *
     * @param category Category which addition in the storage
     */
    public void addCategory(Category category) {
        categories.add(category);
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

    /**
     * Return list all category
     *
     * @return list all Category
     */
    public List<Category> getCategories() {
        return categories;
    }


}
