package com.egar.auction.model;

import java.io.Serializable;

/**
 * Class describe delivery service and it opportunities
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class DeliveryService implements Serializable{
    private double weightPrice;
    private double volumePrice;
    private double distancePrice;
    private double countPrice;
    private double maxWeight;
    private double maxVolume;
    private double minDistance;

    /**
     * Create service with a parameters
     *
     * @param volumePrice
     * @param weightPrice
     * @param maxWeight
     * @param minDistance
     * @param maxVolume
     */
    public DeliveryService(double volumePrice, double weightPrice, double maxWeight,
                           double minDistance, double maxVolume, double distancePrice, double countPrice) {
        this.volumePrice = volumePrice;
        this.weightPrice = weightPrice;
        this.maxWeight = maxWeight;
        this.minDistance = minDistance;
        this.maxVolume = maxVolume;
        this.distancePrice = distancePrice;
        this.countPrice = countPrice;
    }

    public DeliveryService() {
    }

    /**
     * Method return countPrice value
     *
     * @return double coefficient countPrice
     */
    public double getCountPrice() {
        return countPrice;
    }

    /**
     * Put countPrice
     *
     * @param countPrice coefficient countPrice
     */
    public void setCountPrice(double countPrice) {
        this.countPrice = countPrice;
    }

    /**
     * Method return distancePrice value
     *
     * @return double coefficient distancePrice
     */
    public double getDistancePrice() {
        return distancePrice;
    }

    /**
     * Put distancePrice
     *
     * @param distancePrice coefficient distance
     */
    public void setDistancePrice(double distancePrice) {
        this.distancePrice = distancePrice;
    }

    /**
     * Method return weight price value
     *
     * @return double coefficient weightPrice
     */
    public double getWeightPrice() {
        return weightPrice;
    }

    /**
     * Put weightPrice
     *
     * @param weightPrice coefficient weight
     */
    public void setWeightPrice(double weightPrice) {
        this.weightPrice = weightPrice;
    }

    /**
     * Method return volume price value
     *
     * @return double coefficient volumePrice
     */
    public double getVolumePrice() {
        return volumePrice;
    }

    /**
     * Put volumePrice
     *
     * @param volumePrice coefficient volume
     */
    public void setVolumePrice(double volumePrice) {
        this.volumePrice = volumePrice;
    }

    /**
     * Method return maxWeight value
     *
     * @return double maxWeight
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Put maxWeight
     *
     * @param maxWeight maxWeight volume
     */
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Method return maxVolume value
     *
     * @return double maxVolume
     */
    public double getMaxVolume() {
        return maxVolume;
    }

    /**
     * Put maxVolume
     *
     * @param maxVolume double maxVolume volume
     */
    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    /**
     * Method return minDistance value
     *
     * @return double minDistance
     */
    public double getMinDistance() {
        return minDistance;
    }

    /**
     * Put minDistance
     *
     * @param minDistance double minDistance volume
     */
    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    /**
     * Method return string presentation by service
     * @return string information from service
     */
    @Override
    public String toString() {
        return "DeliveryService{" +
                "weightPrice=" + weightPrice +
                ", volumePrice=" + volumePrice +
                ", distancePrice=" + distancePrice +
                ", maxWeight=" + maxWeight +
                ", maxVolume=" + maxVolume +
                ", minDistance=" + minDistance +
                '}';
    }
}
