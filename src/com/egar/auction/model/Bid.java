package com.egar.auction.model;


public class Bid {
    private Good good;
    private double minPrice;
    private double maxPrice;
    private double currentPrice;
    private AuthorizedUser currentBuyer;


    public Bid(double minPrice, double maxPrice, Good good) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.good = good;
        this.currentPrice = 0;
        currentBuyer =null;
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

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public AuthorizedUser getCurrentBuyer() {
        return currentBuyer;
    }

    public void setCurrentBuyer(AuthorizedUser currentBuyer) {
        this.currentBuyer = currentBuyer;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
