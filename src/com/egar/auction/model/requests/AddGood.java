package com.egar.auction.model.requests;

import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Category;

import java.io.Serializable;

/**
 * Team add good
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class AddGood implements Request,Serializable{

    private Category category;
    private String name;
    private String description;
    private double minPrice;
    private int count;
    private int day;
    private int hour;
    private int minutes;
    private double maxPrice;
    private AuthorizedUser owner;
    private double weight;
    private double length;
    private double width;
    private double height;

    /**
     * Create request to add good
     *
     * @param category
     * @param name
     * @param description
     * @param minPrice
     * @param count
     * @param day
     * @param hour
     * @param minutes
     * @param maxPrice
     * @param owner
     * @param weight
     * @param length
     * @param width
     * @param height
     */
    public AddGood(Category category, String name, String description, double minPrice, int count, int day, int hour, int minutes,
                   double maxPrice, AuthorizedUser owner, double weight, double length, double width, double height) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.count = count;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
        this.maxPrice = maxPrice;
        this.owner = owner;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Create request to add good
     */
    public AddGood() {
    }

    /**
     * return category
     *
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * put category
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * return name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * put name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * put description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * return minPrice
     *
     * @return minPrice
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * put minPrice
     *
     * @param minPrice
     */
    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * return count
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * put count
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * return day
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * put day
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * return hour
     *
     * @return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * put hour
     *
     * @param hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * return minutes
     *
     * @return minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * put minutes
     *
     * @param minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * return maxPrice
     *
     * @return maxPrice
     */
    public double getMaxPrice() {
        return maxPrice;
    }

    /**
     * put maxPrice
     *
     * @param maxPrice
     */
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * return owner
     *
     * @return owner
     */
    public AuthorizedUser getOwner() {
        return owner;
    }

    /**
     * put owner
     *
     * @param owner
     */
    public void setOwner(AuthorizedUser owner) {
        this.owner = owner;
    }

    /**
     * return weight
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * put weight
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * return length
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * put length
     *
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * return width
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * put width
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * return height
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * put height
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }
}
