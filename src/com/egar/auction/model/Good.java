package com.egar.auction.model;

/**
 * Created by Эльдар on 15.10.2016.
 */

public class Good {

    private Category category;
    private String name;

    public Good(Category category, String name) {
        this.category = category;

        this.name = name;
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

}
