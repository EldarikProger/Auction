package com.egar.auction.view;

import com.egar.auction.controllers.user_controllers.AdminController;
import com.egar.auction.controllers.user_controllers.AuthorizedUserController;
import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.user_controllers.GuestController;
import com.egar.auction.model.Category;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.console.MainConsole;

import java.io.IOException;

/**
 * Class Module create database and all controllers.
 * Module crate and show view. Module is the entry point of the program.
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Module {

    /**
     * This is the entry point of the program.
     *
     * @param arg arguments with which program started
     */
    public static void main(String[] arg) {
        System.out.println("Это программа Аукцион!");

        AuctionDatabase storage = new AuctionDatabase();

        {
            Category category = new Category("CLOTHING");
            storage.addCategory(category);
            category = new Category("SHOES");
            storage.addCategory(category);
            category = new Category("TELEPHONE");
            storage.addCategory(category);
            category = new Category("AUTO");
            storage.addCategory(category);
            category = new Category("JEWELRY");
            storage.addCategory(category);
            category = new Category("WATCH");
            storage.addCategory(category);
            category = new Category("COMPUTER_EQUIPMENT");
            storage.addCategory(category);
            category = new Category("ELECTRONICS");
            storage.addCategory(category);
            category = new Category("SPORTS_WEAR");
            storage.addCategory(category);
            category = new Category("BUILDING_TOOLS");
            storage.addCategory(category);
            category = new Category("FURNITURE");
            storage.addCategory(category);
            category = new Category("FOOD");
            storage.addCategory(category);
            category = new Category("MUSICAL_INSTRUMENTS");
            storage.addCategory(category);
        }

        GuestController guestController = new GuestController(storage);
        DatabaseController databaseController = new DatabaseController(storage);
        AuthorizedUserController authorizedUserController = new AuthorizedUserController(storage);
        AdminController adminController = new AdminController(storage);
        new MainConsole(adminController, authorizedUserController, databaseController, guestController).show();
    }


}