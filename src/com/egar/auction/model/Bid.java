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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (Double.compare(bid.minPrice, minPrice) != 0) return false;
        if (Double.compare(bid.maxPrice, maxPrice) != 0) return false;
        if (Double.compare(bid.currentPrice, currentPrice) != 0) return false;
        if (good != null ? !good.equals(bid.good) : bid.good != null) return false;
        return currentBuyer != null ? currentBuyer.equals(bid.currentBuyer) : bid.currentBuyer == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = good != null ? good.hashCode() : 0;
        temp = Double.doubleToLongBits(minPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(currentPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currentBuyer != null ? currentBuyer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "good=" + good.toString() +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", currentPrice=" + currentPrice +
                ", currentBuyer=" + currentBuyer +
                '}';
    }
}
