package com.egar.auction.exceptions;

import java.io.Serializable;

/**
 * Exception where user is not found
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class UserNotFoundException extends Exception implements Serializable{

    /**
     * Create User Not Found Exception
     */
    public UserNotFoundException() {
        super("Пользователь не найден!");
    }
}
