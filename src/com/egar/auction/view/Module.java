package com.egar.auction.view;

import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.console.MainConsole;

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

        DatabaseController databaseController = new DatabaseController(AuctionDatabase.getInstance());
        new MainConsole(databaseController).show();
    }


}