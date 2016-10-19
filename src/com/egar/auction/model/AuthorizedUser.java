package com.egar.auction.model;

import java.util.ArrayList;
import java.util.List;


public class AuthorizedUser implements User {

    private String name;
    private String password;
    private List<Good> myGoods;
    private List<Bid> myBids;

    public AuthorizedUser(String name, String password) {
        this.name = name;
        this.password = password;
        myGoods = new ArrayList<>();
        myBids = new ArrayList<>();
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

    public List<Good> getMyGoods() {
        return myGoods;
    }

    public void addGood(Good myGoods) {
        this.myGoods.add(myGoods);
    }

    public List<Bid> getMyBids() {
        return myBids;
    }

    public void makeBid(double minPrice, double maxPrice, Good good){
        myBids.add(new Bid(minPrice,maxPrice,good));
    }

    public void makeBet(double price,Bid bid){
        if(price>bid.getCurrentPrice()){
            bid.setCurrentPrice(price);
            bid.setCurrentBuyer(this);
        }
        if (price>=bid.getMaxPrice()){

        }
    }

}
