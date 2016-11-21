package com.egar.auction.controllers.userControllers;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.*;
import com.egar.auction.storage.AuctionDatabase;

import java.util.*;

/**
 * Class describe management user
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class AuthorizedUserController implements UsersController {

    private AuctionDatabase database;
    private long idGood = 0;
    private long idBid = 0;

    /**
     * Create user controllers
     *
     * @param database storage
     */
    public AuthorizedUserController(AuctionDatabase database) {
        this.database = database;
    }

    /**
     * Method get the user from controllers to clients.
     *
     * @param name     user name
     * @param password user password
     * @throws UserNotFoundException exception if user not found
     * @throws UserException         exception if admins are not
     */
    public AuthorizedUser connectToUser(String name, String password) throws UserNotFoundException, UserException {
        AuthorizedUser user = null;
        if (database.getAuthorizedUsers().size() == 0)
            throw new UserException("Пользователей не существует!");
        for (AuthorizedUser a : database.getAuthorizedUsers()) {
            if (name.equals(a.getName()) && password.equals(a.getPassword()))
                user = a;
        }
        if (user == null)
            throw new UserNotFoundException();
        return user;
    }

    /**
     * Addition to the user a thing
     *
     * @param category    category addition good
     * @param name        name addition good
     * @param description description addition good
     * @param minPrice    min price addition good
     * @param maxPrice    max price addition good
     */
    public void addGood(Category category, String name, String description, double minPrice, int count, int day, int hour,
                        double maxPrice, AuthorizedUser owner, double weight, double length, double width, double height) {
        Calendar endDate = new GregorianCalendar();
        endDate.add(Calendar.DAY_OF_YEAR, day);
        endDate.add(Calendar.HOUR_OF_DAY, hour);
        Good good = new Good(idGood++, category, name, description, minPrice, count, maxPrice, owner, weight, length, width, height);
        good.setEndDateLot(endDate.getTime());
        database.addGood(good);
    }

    /**
     * To bid by the user for the goods
     *
     * @param price price which put to user bid
     * @param good  good which put to user bid
     */
    public void makeBet(double price, Good good, AuthorizedUser user) {
        Bid bid = new Bid(good, price, user, ++idBid);
        database.addBid(bid);
    }

    /**
     * Change user name and password
     *
     * @param name     user name
     * @param password user password
     */
    public void changeUserData(String name, String password, AuthorizedUser user) {
        user.setName(name);
        user.setPassword(password);
    }

    /**
     * Return list user goods
     *
     * @return list goods
     */
    public List<Good> listUserGoods(AuthorizedUser user) {
        List<Good> list = new ArrayList<>();
        for (Good good : database.getAllGoods()) {
            if (user.equals(good.getOwner()))
                list.add(good);
        }
        return list;
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
     * Method return list user bets
     *
     * @return list bids
     */
    public List<Bid> listUserBids(AuthorizedUser user) {
        List<Bid> list = new ArrayList<>();
        for (Bid bid : database.getAllBids()) {
            if (user.equals(bid.getBuyer()))
                list.add(bid);
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
    public List<Category> getListCategory() {
        return database.getCategories();
    }

}
