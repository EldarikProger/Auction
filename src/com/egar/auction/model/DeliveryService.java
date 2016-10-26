package com.egar.auction.model;

/**
 * Class describe delivery service and it opportunities
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class DeliveryService {
    private double weightPrice;
    private double volumePrice;
    private double maxWeight;
    private double maxVolume;
    private double minDistance;

    public DeliveryService(double volumePrice, double weightPrice, double maxWeight, double minDistance, double maxVolume) {
        this.volumePrice = volumePrice;
        this.weightPrice = weightPrice;
        this.maxWeight = maxWeight;
        this.minDistance = minDistance;
        this.maxVolume = maxVolume;
    }

    public double getWeightPrice() {
        return weightPrice;
    }

    public void setWeightPrice(double weightPrice) {
        this.weightPrice = weightPrice;
    }

    public double getVolumePrice() {
        return volumePrice;
    }

    public void setVolumePrice(double volumePrice) {
        this.volumePrice = volumePrice;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }
}
