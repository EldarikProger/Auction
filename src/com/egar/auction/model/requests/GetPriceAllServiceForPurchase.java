package com.egar.auction.model.requests;

import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Purchase;

import java.io.Serializable;

/**
 * Team to get price all service for purchase
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class GetPriceAllServiceForPurchase implements Request, Serializable{

    private AuthorizedUser user;
    private Purchase purchase;

    /**
     * @see GetPriceAllServiceForPurchase#GetPriceAllServiceForPurchase(AuthorizedUser, Purchase)
     */
    public GetPriceAllServiceForPurchase() {
    }

    /**
     * Create request
     *
     * @param user     client user
     * @param purchase client purchase
     */
    public GetPriceAllServiceForPurchase(AuthorizedUser user, Purchase purchase) {
        this.user = user;
        this.purchase = purchase;
    }

    /**
     * Return user user
     *
     * @return user
     */
    public AuthorizedUser getAuthorizedUser() {
        return user;
    }

    /**
     * put user user
     *
     * @param user user user
     */
    public void setAuthorizedUser(AuthorizedUser user) {
        this.user = user;
    }

    /**
     * Return user purchase
     *
     * @return purchase
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * put user purchase
     *
     * @param purchase user purchase
     */
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
