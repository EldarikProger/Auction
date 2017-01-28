package com.egar.auction.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Class describe good and it data
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Good implements Serializable{

    private long id;
    private Category category;
    private String name;
    private String description;
    private double minPrice;
    private double maxPrice;
    private AuthorizedUser owner;

    private double weight;
    private double length, width, height;
    private int count;

    private boolean goodSold = false;

    private Date endDateLot;

    /**
     * Create lot
     *
     * @param id          id good
     * @param category    category good
     * @param name        string name good
     * @param description string description good
     * @param minPrice    double min price good
     * @param maxPrice    double max price good
     * @param count       int count goods
     * @param owner       user-owner good
     * @param weight      double weight good
     * @param length      double length good
     * @param width       double width good
     * @param height      double height good
     */
    public Good(long id, Category category, String name, String description, double minPrice, int count,
                double maxPrice, AuthorizedUser owner, double weight, double length, double width, double height) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.owner = owner;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.goodSold = false;
        this.count = count;
    }

    public Good() {
    }

    /**
     * Return end date
     * @return Date endTimer
     */
    public Date getEndDateLot() {
        return endDateLot;
    }

    /**
     * Put end date lot
     * @param endDateLot end date
     */
    public void setEndDateLot(Date endDateLot) {
        this.endDateLot = endDateLot;
    }

    /**
     * Return count good
     *
     * @return int count goods
     */
    public int getCount() {
        return count;
    }

    /**
     * Put count goods
     *
     * @param count count goods of lot
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Get dimensions good
     *
     * @return volume good
     */
    public double getVolume() {
        return length * width * height;
    }

    /**
     * Set boolean flag which show that good sold
     *
     * @param goodSold boolean flag which show that good sold
     */
    public void setGoodSold(boolean goodSold) {
        this.goodSold = goodSold;
    }

    /**
     * Get id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Get flag which show that good sold
     *
     * @return boolean flag which show that good sold
     */
    public boolean isGoodSold() {
        if(endDateLot.before(new Date()))
            goodSold = true;
        return goodSold;
    }

    /**
     * Get good weight
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set weight to good
     *
     * @param weight weight good
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get good length
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Set length to good
     *
     * @param length length good
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Get good width
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set width to good
     *
     * @param width width good
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get good height
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set height to good
     *
     * @param height height good
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get good owner
     *
     * @return user-owner good
     */
    public AuthorizedUser getOwner() {
        return owner;
    }


    /**
     * Put AuthorizedUser - owner to good
     *
     * @param owner user-owner good
     */
    public void setOwner(AuthorizedUser owner) {
        this.owner = owner;
    }

    /**
     * Get good min price
     *
     * @return min price
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * Put to good min price
     *
     * @param minPrice min price good
     */
    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * Get good max price
     *
     * @return max price
     */
    public double getMaxPrice() {
        return maxPrice;
    }

    /**
     * Put to good max price
     *
     * @param maxPrice max price good
     */
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * Get good category
     *
     * @return category good
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Put category
     *
     * @param category category which belong good
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Get good name
     *
     * @return name good
     */
    public String getName() {
        return name;
    }

    /**
     * Set name to good
     *
     * @param name name good
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get good description
     *
     * @return description good
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description to the good
     *
     * @param description description good
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return true if all good fields coincide with Object fields
     * else return false
     *
     * @param o object with which compare
     * @return boolean value: true if object and good equally
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (id != good.id) return false;
        if (Double.compare(good.minPrice, minPrice) != 0) return false;
        if (Double.compare(good.maxPrice, maxPrice) != 0) return false;
        if (Double.compare(good.weight, weight) != 0) return false;
        if (Double.compare(good.length, length) != 0) return false;
        if (Double.compare(good.width, width) != 0) return false;
        if (Double.compare(good.height, height) != 0) return false;
        if (category != good.category) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        if (description != null ? !description.equals(good.description) : good.description != null) return false;
        return owner != null ? owner.equals(good.owner) : good.owner == null;

    }

    /**
     * Return hash good
     *
     * @return hash good
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(minPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Represent Good in string form
     *
     * @return good to string format
     */
    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", owner=" + owner +
                ", weight=" + weight +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
