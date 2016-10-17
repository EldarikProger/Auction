package com.egar.auction.model;

import java.util.ArrayList;
import java.util.List;


public class AuctionDatabase {
    private List<AuthorizedUser> authorizedUsers;
    private List<Admin> admins;
    private List<Bid> allBids;

    public AuctionDatabase() {
        allBids=new ArrayList<>();
        admins=new ArrayList<>();
        authorizedUsers=new ArrayList<>();
    }

    public void addAuthorizedUser(AuthorizedUser user){
        authorizedUsers.add(user);
    }

    public void addAdmin(Admin user){
        admins.add(user);
    }

    public void addBid(Bid bid){
        allBids.add(bid);
    }

    public List<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Bid> getAllBids() {
        return allBids;
    }
}
