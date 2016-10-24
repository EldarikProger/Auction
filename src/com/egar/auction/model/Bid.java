package com.egar.auction.model;

/**
 * Class describe bid (user bet) and it data
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Bid {
    private long id;
    private Good good;
    private double price;
    private AuthorizedUser buyer;

    /**
     * Create bid
     *
     * @param good good on which make bet
     * @param price price bet
     * @param buyer user which make bet
     * @param id id bid
     */
    public Bid(Good good, double price, AuthorizedUser buyer, long id) {
        this.good = good;
        this.price = price;
        this.buyer = buyer;
        this.id = id;
    }

    /**
     * Return id
     *
     * @return id bid
     */
    public long getId() {
        return id;
    }

    /**
     * Return price
     *
     * @return price bet
     */
    public double getPrice() {
        return price;
    }

    /**
     * Put price to bid
     *
     * @param currentPrice set new price bet
     */
    public void setPrice(double currentPrice) {
        this.price = currentPrice;
    }

    /**
     * Return AuthorizedUser - buyer
     *
     * @return user which mke bet
     */
    public AuthorizedUser getBuyer() {
        return buyer;
    }

    /**
     * Return good
     *
     * @return good bid
     */
    public Good getGood() {
        return good;
    }

    /**
     * Return true if all bid fields coincide with Object fields
     * else return false
     *
     * @param o object with which compare
     * @return boolean value: true if object and bid equally
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (id != bid.id) return false;
        if (Double.compare(bid.price, price) != 0) return false;
        if (good != null ? !good.equals(bid.good) : bid.good != null) return false;
        return buyer != null ? buyer.equals(bid.buyer) : bid.buyer == null;

    }

    /**
     * Return hash bid
     *
     * @return hash bid
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (good != null ? good.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        return result;
    }

    /**
     * Represent Bid in string form
     *
     * @return to string bid
     */
    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", good=" + good + ", \n" +
                "price=" + price +
                ", buyer=" + buyer +
                '}';
    }
}
