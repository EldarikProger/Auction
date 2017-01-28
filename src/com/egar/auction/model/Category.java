package com.egar.auction.model;

import java.io.Serializable;

/**
 * Category describe category goods
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Category implements Serializable{

    private String name;

    public Category() {
    }

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
