package com.egar.auction.controllers;

import com.egar.auction.exceptions.DistanceException;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.*;
import com.egar.auction.storage.AuctionDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class describe management service
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class DeliveryServiceController implements Controller {

    private AuctionDatabase database;

    /**
     * Create controller
     *
     * @param database
     */
    public DeliveryServiceController(AuctionDatabase database) {
        this.database = database;
    }

    /**
     * Return string list price and service
     *
     * @param purchase Purchase
     * @param user     AuthorizedUser
     * @return string list price and service
     */
    public List<PriceService> getPriceAllServiceForPurchase(Purchase purchase, AuthorizedUser user) throws DistanceException {
        List<PriceService> list = new ArrayList<>();
        String price;
        for (DeliveryService service : database.getServices()) {
            try {
                list.add(new PriceService(String.valueOf(getPriceForDelivery(purchase.getGood(), user, service)), service));
            } catch (UserException e) {
                list.add(new PriceService(e.getMessage(),service));
            }
        }
        return list;
    }

    /**
     * Return List DeliveryService
     *
     * @return List DeliveryService
     */
    public List<DeliveryService> getListDeliveryService() {
        return database.getServices();
    }

    /**
     * Method return price delivery
     *
     * @param good Good which need delivery
     * @return price delivery good
     */
    private double getPriceForDelivery(Good good, AuthorizedUser buyer, DeliveryService service) throws UserException, DistanceException {
        double distance = DistanceController.distance(good.getOwner(), buyer);
        if (distance < service.getMinDistance())
            throw new UserException("Сервис не работает на таких расстояниях между покупателем и продавцом!");
        if (good.getWeight() > service.getMaxWeight())
            throw new UserException("Сервис не подходит! Товар тяжелее чем заданное значение.");
        if (good.getVolume() > service.getMaxVolume())
            throw new UserException("Сервис не подходит! Размеры товара выше чем заданное значение.");
        return good.getVolume() * service.getVolumePrice() /*+ good.getCount() * service.getCountPrice()*/ +
                good.getWeight() * service.getWeightPrice() + distance * service.getDistancePrice();
    }

}
