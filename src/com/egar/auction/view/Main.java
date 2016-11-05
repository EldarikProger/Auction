package com.egar.auction.view;

import com.egar.auction.controllers.user_controllers.AdminController;
import com.egar.auction.controllers.user_controllers.AuthorizedUserController;
import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.user_controllers.GuestController;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.first_console.ConsoleView;

/**
 * Class Main create database and all controllers.
 * Main crate and show view. Main is the entry point of the program.
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Main {

    /**
     * This is the entry point of the program.
     *
     * @param arg arguments with which program started
     */
    public static void main(String[] arg) {
        System.out.println("Это программа Аукцион!");
        AuctionDatabase database = new AuctionDatabase();
        GuestController controlG = new GuestController(database);
        DatabaseController controlD = new DatabaseController(database);
        AuthorizedUserController controlAU = new AuthorizedUserController(database);
        AdminController controlA = new AdminController(database);
        new ConsoleView(controlA, controlAU, controlD, controlG);
    }
}
