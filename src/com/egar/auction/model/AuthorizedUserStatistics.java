package com.egar.auction.model;


/**
 * Describe user statistics
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class AuthorizedUserStatistics {
    private AuthorizedUser user;
    private int numberGoods;
    private int numberBids;

    /**
     * Create user statistics
     *
     * @param user user at which conduct statistics
     * @param numberGoods user number goods
     * @param numberBids user number bids
     */
    public AuthorizedUserStatistics(AuthorizedUser user, int numberGoods, int numberBids) {
        this.numberGoods = numberGoods;
        this.user = user;
        this.numberBids = numberBids;
    }

    /**
     * Method return number goods
     *
     * @return user number goods
     */
    public int getNumberGoods() {
        return numberGoods;
    }

    /**
     * Return user
     *
     * @return user at which conduct statistics
     */
    public AuthorizedUser getUser() {
        return user;
    }

    /**
     * Method return number bids
     *
     * @return user number bids
     */

    public int getNumberBids() {
        return numberBids;
    }

    /**
     * Represent statistics in the string form
     *
     * @return statistics to string
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
