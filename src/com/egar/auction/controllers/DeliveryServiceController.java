package com.egar.auction.controllers;

import com.egar.auction.model.DeliveryService;
import com.egar.auction.model.Good;

import java.util.List;

/**
 * Class describe management service
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class DeliveryServiceController implements Controller {
    private DeliveryService service;

    private double getPriceForDelivery(Good good){
        return 0;
    }

    public double getCommonPrice(List<Good> list){
        return 0;
    }

}
