package com.egar.auction.model;


import java.io.Serializable;

/**
 * Guest is the user. Class Guest have user data
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Guest implements User, Serializable {

    private String name;

    /**
     * Create guest
     *
     * @param name user name
     */
    public Guest(String name) {
        this.name = name;
    }

    public Guest() {
    }

    /**
     * Return guest name
     *
     * @return guest name
     */
    public String getName() {
        return name;
    }

}
