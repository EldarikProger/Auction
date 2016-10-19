package com.egar.auction.controller;

import com.egar.auction.model.Admin;
import com.egar.auction.model.AuctionDatabase;

/**
 * Created by Эльдар on 19.10.2016.
 */
public class ControlAdmin implements Controller {
    private AuctionDatabase database;
    private Admin admin;

    public ControlAdmin(AuctionDatabase database) {
        this.database = database;
    }


}
