package com.egar.auction.model;

/**
 * Created by Эльдар on 15.10.2016.
 */
public class Bid {

    private double minPrice;
    private double maxPrice;
    private Good good;

    public Bid(double minPrice, double maxPrice, Good good) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.good = good;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
