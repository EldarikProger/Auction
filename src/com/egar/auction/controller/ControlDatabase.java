package com.egar.auction.controller;

import com.egar.auction.model.Admin;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.model.AuthorizedUser;

import java.util.List;

/**
 * ControlDatabase manage storage.
 * ControlDatabase create and delete users.
 */
public class ControlDatabase implements Controller {
    private AuctionDatabase database;
    private static long userId = 0;

    /**
     * Create ControlDatabase
     *
     * @param database
     */
    public ControlDatabase(AuctionDatabase database) {
        this.database = database;
    }

    /**
     * Create new AuthorizedUser
     *
     * @param name
     * @param password
     */
    public void createAuthorizedUser(String name, String password) {
        database.addAuthorizedUser(new AuthorizedUser(name, password, ++userId));
    }

    /**
     * Create new Admin
     *
     * @param name
     * @param password
     */
    public void createAdmin(String name, String password) {
        database.addAdmin(new Admin(name, password, ++userId));
    }

    /**
     * Method delete admin from storage
     *
     * @param name
     * @param password
     */
    public void deleteAdmin(String name, String password) {
        List<Admin> list = database.getAdmins();
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName()) && password.equals(list.get(i).getPassword()))
                list.remove(i);
        }
    }

    /**
     * Method delete user from storage
     *
     * @param name
     * @param password
     */
    public void deleteAuthorizedUser(String name, String password) {
        List<AuthorizedUser> list = database.getAuthorizedUsers();
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName()) && password.equals(list.get(i).getPassword()))
                list.remove(i);
        }
    }

}
