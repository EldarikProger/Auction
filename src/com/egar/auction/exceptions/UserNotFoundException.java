package com.egar.auction.exceptions;

/**
 * Exception where user is not found
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Пользователь не найден!");
    }
}
