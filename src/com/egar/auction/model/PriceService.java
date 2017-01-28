package com.egar.auction.model;

import java.io.Serializable;

/**
 * Link price delivery with service
 */
public class PriceService implements Serializable
{

    private String price;
    private DeliveryService service;

    public PriceService() {
    }

    /**
     * Return price
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     * Return service
     * @return
     */
    public DeliveryService getService() {
        return service;
    }

    /**
     * create PriceService
     */
    public PriceService(String price, DeliveryService service) {
        this.price = price;
        this.service = service;
    }

    /**
     * to String price and service
     * @return
     */
    @Override
    public String toString() {
        return "PriceService{" +
                "price='" + price + '\'' +
                ", service=" + service +
                '}';
    }
}
