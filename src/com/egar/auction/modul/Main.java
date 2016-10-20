package com.egar.auction.modul;

import com.egar.auction.controller.ControlAdmin;
import com.egar.auction.controller.ControlAuthorizedUser;
import com.egar.auction.controller.ControlDatabase;
import com.egar.auction.controller.ControlGuest;
import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.view.console.ConsoleView;


public class Main {

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
