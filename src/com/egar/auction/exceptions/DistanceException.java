package com.egar.auction.exceptions;


import java.io.Serializable;

public class DistanceException extends Exception implements Serializable{

    /**
     * Create UserException
     */
    public DistanceException() {
        super("Расстояние между покупателем и продавцом невозможно вычислить!");
    }
}
