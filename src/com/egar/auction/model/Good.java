package com.egar.auction.model;


public class Good {

    private Category category;
    private String name;
    private String description;

    public Good(Category category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
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

        if (category != good.category) return false;
        if (name != null ? !name.equals(good.name) : good.name != null) return false;
        return description != null ? description.equals(good.description) : good.description == null;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "category: " + category +
                "; name: " + name +
                "; description: " + description +
                '}';
    }
}
