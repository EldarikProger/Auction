package com.egar.auction.model;

/**
 * Class associate good with service
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Purchase {

    private AuthorizedUser buyer;
    private Bid bidByGood;
    private Good good;
    private DeliveryService service;

    /**
     * @param user buyer which belongs this object
     * @param good good which user win
     * @param service service by which delivery good
     * @param bid bet by good
     */
    public Purchase(AuthorizedUser user, Good good, DeliveryService service,Bid bid) {
        this.buyer = user;
        this.good = good;
        this.service = service;
        this.bidByGood = bid;
    }

    /**
     * Return bet which made by good
     * @return bid
     */
    public Bid getBidByGood() {
        return bidByGood;
    }

    /**
     * Put bid by good
     * @param bidByGood bet by good
     */
    public void setBidByGood(Bid bidByGood) {
        this.bidByGood = bidByGood;
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
