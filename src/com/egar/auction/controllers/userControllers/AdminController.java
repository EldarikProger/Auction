package com.egar.auction.controllers.userControllers;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.*;
import com.egar.auction.storage.AuctionDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describe management admin
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class AdminController implements UsersController {

    private AuctionDatabase database;

    /**
     * Create admin controllers
     */
    public AdminController() {
        this.database = AuctionDatabase.getInstance();
    }

    /**
     * Method sets the admin to controllers. AdminController will manage the admin.
     *
     * @param name user name
     * @param password user password
     * @throws UserNotFoundException exception if user not found
     * @throws UserException exception if admins are not
     */
    public Admin connectToAdmin(String name, String password) throws UserNotFoundException, UserException {
        Admin admin = null;
        if (database.getAdmins().size() == 0)
            throw new UserException("Администраторов не существует");
        for (Admin a : database.getAdmins()) {
            if (name.equals(a.getName()) && password.equals(a.getPassword()))
                admin = a;
        }
        if (admin == null)
            throw new UserNotFoundException();
        return admin;
    }

    /**
     * Method change admin name and password
     *
     * @param name user name
     * @param password user password
     */
    public void changeAdminData(String name, String password, Admin admin) {
        admin.setName(name);
        admin.setPassword(password);
    }

    /**
     * Method return list all AuthorizedUsers
     *
     * @return list users
     */
    public List listAllUsers() {
        return database.getAuthorizedUsers();
    }

    /**
     * Method return list all Admins
     *
     * @return list admins
     */
    public List listAllAdmins() {
        return database.getAdmins();
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
     * Method return number user goods and bid (all statistics bu user)
     *
     * @return list user statistics
     */
    public List<AuthorizedUserStatistics> getUserStatistics() {
        int k = 0, l = 0;
        List<AuthorizedUserStatistics> list = new ArrayList<>();
        for (AuthorizedUser user : database.getAuthorizedUsers()) {
            for (Good good : database.getAllGoods()) {
                if (user.equals(good.getOwner())) {
                    k++;
                }
            }
            for (Bid bid : database.getAllBids()) {
                if (user.equals(bid.getBuyer())) {
                    l++;
                }
            }
            list.add(new AuthorizedUserStatistics(user, k, l));
            k = 0;
            l = 0;
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
