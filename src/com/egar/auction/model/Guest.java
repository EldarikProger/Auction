package com.egar.auction.model;


/**
 * Guest is the user. Class Guest have user data
 */
public class Guest implements User {

    private String name;

    /**
     * Create guest
     *
     * @param name
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Return guest name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

}
