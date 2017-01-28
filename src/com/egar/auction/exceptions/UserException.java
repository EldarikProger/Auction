package com.egar.auction.exceptions;

import java.io.Serializable;

/**
 * Common user exception
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class UserException extends Exception implements Serializable {

    /**
     * Create UserException
     *
     * @param message string with the message
     */
    public UserException(String message) {
        super(message);
    }
}
