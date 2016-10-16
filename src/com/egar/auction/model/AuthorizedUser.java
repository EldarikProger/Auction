package com.egar.auction.model;

import java.util.List;

/**
 * Created by Эльдар on 15.10.2016.
 */
public class AuthorizedUser implements User {

    private String name;
    private String password;
    private List<Good> myGoods;
    private List<Bid> myBids;

    public AuthorizedUser(String name, String password) {
        this.name = name;
        this.password = password;
        myGoods = null;
        myBids = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
