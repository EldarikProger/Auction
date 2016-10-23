package com.egar.auction.view;

import com.egar.auction.controller.ControlAdmin;
import com.egar.auction.controller.ControlAuthorizedUser;
import com.egar.auction.controller.ControlDatabase;
import com.egar.auction.controller.ControlGuest;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.console.ConsoleView;

/**
 * Class Main create database and all controllers.
 * Main crate and show view. Main is the entry point of the program.
 */
public class Main {

    /**
     * This is the entry point of the program.
     *
     * @param arg
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
