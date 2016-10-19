package com.egar.auction.controller;

import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.List;


public class ControlAuthorizedUser implements Controller{
    private AuthorizedUser user;
    private AuctionDatabase database;

    public ControlAuthorizedUser(AuctionDatabase database) {
        this.database = database;
    }

    public AuthorizedUser getUser() {
        return user;
    }

    public void setUser(AuthorizedUser user) {
        this.user = user;
    }

    public void addGood(Good good){

    }

    public void putBid(){

    }

    public  void makeBet(int price){

    }

    public void changeUserData(String name,String password){

    }

    public List viewUserGoods(){
        return null;
    }

    public List viewUserGoodsByCategory(Category category){
        return null;
    }

    public List viewUserBids(){
        return  null;
    }

    public List viewAllBids(){
        return null;
    }

}
