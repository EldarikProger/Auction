package com.egar.auction.view;

import com.egar.auction.controllers.user_controllers.ControlAdmin;
import com.egar.auction.controllers.user_controllers.ControlAuthorizedUser;
import com.egar.auction.controllers.ControlDatabase;
import com.egar.auction.controllers.user_controllers.ControlGuest;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.console.ConsoleView;

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
        ControlGuest controlG = new ControlGuest(database);
        ControlDatabase controlD = new ControlDatabase(database);
        ControlAuthorizedUser controlAU = new ControlAuthorizedUser(database);
        ControlAdmin controlA = new ControlAdmin(database);
        new ConsoleView(controlA, controlAU, controlD, controlG);
    }
}
