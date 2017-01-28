package com.egar.auction.model.requests;


import com.egar.auction.model.DeliveryService;
import com.egar.auction.model.Purchase;

import java.io.Serializable;

/**
 * Team to set delivery service to purchase
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class SetDeliveryServiceToPurchase implements Request, Serializable {

    private DeliveryService service;
    private Purchase purchase;
    private double price;

    /**
     * @see SetDeliveryServiceToPurchase#SetDeliveryServiceToPurchase(DeliveryService, Purchase, double)
     */
    public SetDeliveryServiceToPurchase() {
    }

    /**
     * Create request
     *
     * @param service  client service
     * @param purchase client purchase
     * @param price    client price for purchase
     */
    public SetDeliveryServiceToPurchase(Purchase purchase, DeliveryService service, double price) {
        this.service = service;
        this.purchase = purchase;
        this.price = price;
    }

    /**
     * Return user service
     *
     * @return service
     */
    public DeliveryService getDeliveryService() {
        return service;
    }

    /**
     * put user service
     *
     * @param service user
     */
    public void setDeliveryService(DeliveryService service) {
        this.service = service;
    }

    /**
     * Return user purchase
     *
     * @return purchase
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * put user purchase
     *
     * @param purchase user purchase
     */
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    /**
     * Return user purchase price
     *
     * @return purchase price
     */
    public double getPrice() {
        return price;
    }

    /**
     * put user purchase price
     *
     * @param price user purchase price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
