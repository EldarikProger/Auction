package com.egar.auction.model.requests;

import com.egar.auction.model.Category;

import java.io.Serializable;

/**
 * Request to return list all goods
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class ViewAllGoods implements Request, Serializable {

    private Category category;

    /**
     * Create Request
     *
     * @param category @see {@link Category}
     */
    public ViewAllGoods(Category category) {
        this.category = category;
    }

    /**
     * Create Request
     */
    public ViewAllGoods() {
    }

    /**
     * Return Category
     *
     * @return Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Put Category
     *
     * @param category @see {@link Category}
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
