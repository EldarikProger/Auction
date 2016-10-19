package com.egar.auction.controller;

import com.egar.auction.model.AuctionDatabase;

import java.util.List;


public class ControlGuest implements Controller{
    private AuctionDatabase database;

    public ControlGuest(AuctionDatabase database) {
        this.database = database;
    }

    public List viewAllBids(){
        return database.getAllBids();
    }
}
