package com.egar.auction.model;


public class Bid {
    private Good good;
    private double price;
    private AuthorizedUser buyer;


    public Bid(Good good, double price, AuthorizedUser buyer) {
        this.good = good;
        this.price = price;
        this.buyer = buyer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double currentPrice) {
        this.price = currentPrice;
    }

    public AuthorizedUser getBuyer() {
        return buyer;
    }

    public void setBuyer(AuthorizedUser currentBuyer) {
        this.buyer = currentBuyer;
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

        if (Double.compare(bid.price, price) != 0) return false;
        if (good != null ? !good.equals(bid.good) : bid.good != null) return false;
        return buyer != null ? buyer.equals(bid.buyer) : bid.buyer == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = good != null ? good.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "good=" + good +
                ", price=" + price +
                ", buyer=" + buyer +
                '}';
    }
}
