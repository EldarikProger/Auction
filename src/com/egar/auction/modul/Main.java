package com.egar.auction.modul;

import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.view.console.ConsoleView;


public class Main {

    public static void main(String[] arg){
        System.out.println("This is Auction!");
        new ConsoleView(new AuctionDatabase());
    }
}
