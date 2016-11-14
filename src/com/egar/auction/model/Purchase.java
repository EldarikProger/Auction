package com.egar.auction.model;

/**
 * Class associate good with service
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Purchase {

    private AuthorizedUser buyer;
    private Good good;
    private DeliveryService service;

    /**
     * @param user    buyer which belongs this object
     * @param good
     * @param service
     */
    public Purchase(AuthorizedUser user, Good good, DeliveryService service) {
        this.buyer = user;
        this.good = good;
        this.service = service;
    }

    /**
     * User which belongs this object
     *
     * @return buyer
     */
    public AuthorizedUser getBuyer() {
        return buyer;
    }

    /**
     * Put buyer which belongs this object
     *
     * @param buyer which belongs this object
     */
    public void setBuyer(AuthorizedUser buyer) {
        this.buyer = buyer;
    }

    /**
     * Return good with which belongs buyer
     *
     * @return good
     */
    public Good getGood() {
        return good;
    }

    /**
     * Put good with which belongs buyer
     *
     * @param good with which belongs buyer
     */
    public void setGood(Good good) {
        this.good = good;
    }

    /**
     * Return service with which belongs buyer
     *
     * @return delivery service
     */
    public DeliveryService getService() {
        return service;
    }

    /**
     * Put service with which belongs buyer
     *
     * @param service with which belongs buyer
     */
    public void setService(DeliveryService service) {
        this.service = service;
    }
}
