package com.egar.auction.model.requests;


import com.egar.auction.model.Good;

import java.io.Serializable;

/**
 * Request to return list all goods
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class ViewAllBids implements Request, Serializable {

    private Good good;

    /**
     * Create Request
     *
     * @param good @see {@link Good}
     */
    public ViewAllBids(Good good) {
        this.good = good;
    }

    /**
     * Create Request
     */
    public ViewAllBids() {
    }

    /**
     * Return Category
     *
     * @return Category
     */
    public Good getUser() {
        return good;
    }

    /**
     * Put Category
     *
     * @param good @see {@link Good}
     */
    public void setUser(Good good) {
        this.good = good;
    }
}
