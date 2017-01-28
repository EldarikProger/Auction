package com.egar.auction.exceptions;

import java.io.Serializable;

/**
 * Created custom exception
 */
public class UserExitException extends Exception implements Serializable {

    /**
     * Create exception
     */
    public UserExitException() {
        super();
    }
}
