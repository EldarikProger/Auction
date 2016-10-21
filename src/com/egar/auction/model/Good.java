package com.egar.auction.model;


import java.util.ArrayList;
import java.util.List;

public class Good {

    private Category category;
    private String name;
    private String description;
    private double minPrice;
    private double maxPrice;
    private List<Bid> bidList;
    private AuthorizedUser owner;

    public Good(Category category, String name, String description, double minPrice, double maxPrice, AuthorizedUser owner) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.owner = owner;
        bidList = new ArrayList<>();
    }

    public AuthorizedUser getOwner() {
        return owner;
    }

    public void setOwner(AuthorizedUser owner) {
        this.owner = owner;
    }

    public void addBid(Bid bid){
        bidList.add(bid);
    }

    public List<Bid> getBidList() {
        return bidList;
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

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (Double.compare(good.minPrice, minPrice) != 0) return false;
        if (Double.compare(good.maxPrice, maxPrice) != 0) return false;
        if (category != good.category) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        return description != null ? description.equals(good.description) : good.description == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = category != null ? category.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(minPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
