package com.egar.auction.model.requests;

import com.egar.auction.model.AuthorizedUser;

import java.io.Serializable;

/**
 * Request to get common price by purchases
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class GetCommonPrice implements Request, Serializable {

    private AuthorizedUser user;

    /**
     * Create Request
     *
     * @param user @see {@link AuthorizedUser}
     */
    public GetCommonPrice(AuthorizedUser user) {
        this.user = user;
    }

    /**
     * Create Request
     */
    public GetCommonPrice() {
    }

    /**
     * Return User
     *
     * @return User
     */
    public AuthorizedUser getUser() {
        return user;
    }

    /**
     * Put User
     *
     * @param user @see {@link AuthorizedUser}
     */
    public void setUser(AuthorizedUser user) {
        this.user = user;
    }
}
