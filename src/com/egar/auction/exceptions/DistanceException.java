package com.egar.auction.exceptions;


public class DistanceException extends Exception{

    /**
     * Create UserException
     */
    public DistanceException() {
        super("Расстояние между покупателем и продавцом невозможно вычислить!");
    }
}
