package com.egar.auction.controllers;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.DeliveryService;
import com.egar.auction.model.Good;
import com.egar.auction.storage.AuctionDatabase;

/**
 * Class describe management service
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class DeliveryServiceController implements Controller {

    private DeliveryService service;

    /**
     * Method return service which manage controller
     * @return service by delivery
     */
    public DeliveryService getService() {
        return service;
    }

    /**
     * Put service to controller
     * @param service by delivery
     */
    public void setService(DeliveryService service) {
        this.service = service;
    }

    /**
     *Method return price delivery
     *
     * @param good Good which need delivery
     * @return price delivery good
     */
    public double getPriceForDelivery(Good good, AuthorizedUser buyer) throws UserException {
        double distance = DistanceController.distance(good.getOwner(),buyer);
        if(distance<service.getMinDistance())
            throw new UserException("Сервис не работает на таких расстояниях между покупателем и продавцом!");
        if (good.getWeight()>service.getMaxWeight())
            throw new UserException("Сервис не подходит! Товар тяжелее чем заданное значение.");
        if(good.getVolume() > service.getMaxVolume())
            throw new UserException("Сервис не подходит! Размеры товара выше чем заданное значение.");
        return good.getVolume()*service.getVolumePrice()+
                good.getWeight()*service.getWeightPrice()+
                distance*service.getDistancePrice();
    }

}
