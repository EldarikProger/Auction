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

    public List<Bid> getMyBids() {
        return myBids;
    }

    public void addGood(Good good){
        myGoods.add(good);
    }

    public void addBid(Bid bid){
        myBids.add(bid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizedUser user = (AuthorizedUser) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                ", name = " + name +
                '}';
    }
}
