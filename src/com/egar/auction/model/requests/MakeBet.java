package com.egar.auction.model.requests;

import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Good;

import java.io.Serializable;

/**
 * Team to make bet
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class MakeBet implements Request, Serializable {

    private double price;
    private Good good;
    private AuthorizedUser user;

    /**
     * Create request to add good
     */
    public MakeBet() {

    }

    /**
     * @param price price bet
     * @param good  bet on the good
     * @param user  user which make bet
     * @see MakeBet#MakeBet()
     */
    public MakeBet(double price, Good good, AuthorizedUser user) {
        this.price = price;
        this.good = good;
        this.user = user;
    }

    /**
     * return price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * put price
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * return good
     *
     * @return good
     */
    public Good getGood() {
        return good;
    }

    /**
     * put good
     *
     * @param good
     */
    public void setGood(Good good) {
        this.good = good;
    }

    /**
     * return user
     *
     * @return user
     */
    public AuthorizedUser getUser() {
        return user;
    }

    /**
     * put user
     *
     * @param user
     */
    public void setUser(AuthorizedUser user) {
        this.user = user;
    }
}
