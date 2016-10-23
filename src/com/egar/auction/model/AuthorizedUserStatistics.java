package com.egar.auction.model;


/**
 * Describe user statistics
 */
public class AuthorizedUserStatistics {
    private AuthorizedUser user;
    private int numberGoods;
    private int numberBids;

    /**
     * Create user statistics
     *
     * @param numberGoods
     * @param numberBids
     */
    public AuthorizedUserStatistics(AuthorizedUser user, int numberGoods, int numberBids) {
        this.numberGoods = numberGoods;
        this.user = user;
        this.numberBids = numberBids;
    }

    /**
     * Method return number goods
     *
     * @return
     */
    public int getNumberGoods() {
        return numberGoods;
    }

    /**
     * Return user
     *
     * @return
     */
    public AuthorizedUser getUser() {
        return user;
    }

    /**
     * Method return number bids
     *
     * @return
     */

    public int getNumberBids() {
        return numberBids;
    }

    /**
     * Represent statistics in the string form
     *
     * @return
     */
    @Override
    public String toString() {
        return "AuthorizedUserStatistics{" +
                "user=" + user +
                ", numberGoods=" + numberGoods +
                ", numberBids=" + numberBids +
                '}';
    }
}
