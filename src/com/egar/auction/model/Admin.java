package com.egar.auction.model;

import java.util.List;

/**
 * Created by Эльдар on 15.10.2016.
 */
public class Admin implements User {

    private String name;
    private String password;
    private AuctionDatabase database;


    public Admin(String name, String password, AuctionDatabase database) {
        this.name = name;
        this.password = password;
        this.database = database;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public List viewAllBids() {
        return null;
    }
}
