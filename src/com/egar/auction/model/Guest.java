package com.egar.auction.model;

import java.util.List;

/**
 * Created by Эльдар on 15.10.2016.
 */
public class Guest implements User {

    private String name;

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public List viewAllBids() {
        return null;
    }
}
