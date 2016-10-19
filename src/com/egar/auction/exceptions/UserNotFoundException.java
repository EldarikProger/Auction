package com.egar.auction.exceptions;

/**
 * Created by Эльдар on 19.10.2016.
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Пользователь не найден!");
    }
}
