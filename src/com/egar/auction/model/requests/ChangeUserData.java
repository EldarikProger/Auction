package com.egar.auction.model.requests;

import com.egar.auction.model.AuthorizedUser;

import java.io.Serializable;

/**
 * Team to change user name and password
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class ChangeUserData implements Request, Serializable {

    private String name;
    private String password;
    private AuthorizedUser user;

    /**
     * @see ChangeUserData#ChangeUserData(String, String, AuthorizedUser)
     */
    public ChangeUserData() {
    }

    /**
     * Create request
     *
     * @param name     client name
     * @param password client password
     * @param user
     */
    public ChangeUserData(String name, String password, AuthorizedUser user) {
        this.name = name;
        this.password = password;
        this.user = user;
    }

    /**
     * Return new user name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * put new user name
     *
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return new user password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * put new user password
     *
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return user
     *
     * @return user
     */
    public AuthorizedUser getUser() {
        return user;
    }

    /**
     * put user
     *
     * @param user user
     */
    public void setUser(AuthorizedUser user) {
        this.user = user;
    }
}
