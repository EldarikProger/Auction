package com.egar.auction.controller;

import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.Admin;
import com.egar.auction.model.AuctionDatabase;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Bid;

import java.util.List;


public class ControlAdmin implements Controller {
    private AuctionDatabase database;
    private Admin admin;

    public ControlAdmin(AuctionDatabase database) {
        this.database = database;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void changeAdminData(String name, String password) {
        admin.setName(name);
        admin.setPassword(password);
    }

    public List viewListUsers(){
        return database.getAuthorizedUsers();
    }

    public List viewListAdmins(){
        return database.getAdmins();
    }

    public List viewListUserGoods(String userName) throws UserNotFoundException {
        for (AuthorizedUser a: database.getAuthorizedUsers()) {
            if(userName.equals(a.getName()))
                return a.getMyGoods();
        }
        throw new UserNotFoundException();
    }

    public List viewListUserBids(String userName) throws UserNotFoundException {
        for (AuthorizedUser a: database.getAuthorizedUsers()) {
            if(userName.equals(a.getName()))
                return a.getMyBids();
        }
        throw new UserNotFoundException();
    }

    public List<Bid> viewAllBids() {
        return database.getAllBids();
    }

}
