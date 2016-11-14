package com.egar.auction.model;

/**
 * Category describe category goods
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Category {

    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
