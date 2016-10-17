package com.egar.auction.modul;

import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;
import com.egar.auction.view.console.ConsoleView;

/**
 * Created by Эльдар on 15.10.2016.
 */
public class Main {

    public static void main(String[] arg){
        System.out.println("This is Auction!");
        ConsoleView consoleView = new ConsoleView(new AuctionDatabase());
        consoleView.start();
    }
}
