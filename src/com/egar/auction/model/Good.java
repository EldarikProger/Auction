package com.egar.auction.model;

/**
 * Class describe good and it data
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Good {

    private long id;
    private Category category;
    private String name;
    private String description;
    private double minPrice;
    private double maxPrice;
    private AuthorizedUser owner;

    /**
     * Create new object good
     *
     * @param category category which belong good
     * @param name name good
     * @param description description good
     * @param minPrice min price good
     * @param maxPrice max price good
     * @param owner user which belong good
     * @param id id good
     */
    public Good(Category category, String name, String description, double minPrice, double maxPrice, AuthorizedUser owner, long id) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.owner = owner;
        this.id = id;
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
                "owner=" + owner +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", category=" + category +
                '}';
    }
}
