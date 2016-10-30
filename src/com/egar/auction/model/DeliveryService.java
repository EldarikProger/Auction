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

    /**
     * Create service with a parameters
     *
     * @param volumePrice
     * @param weightPrice
     * @param maxWeight
     * @param minDistance
     * @param maxVolume
     */
    public DeliveryService(double volumePrice, double weightPrice, double maxWeight, double minDistance, double maxVolume) {
        this.volumePrice = volumePrice;
        this.weightPrice = weightPrice;
        this.maxWeight = maxWeight;
        this.minDistance = minDistance;
        this.maxVolume = maxVolume;
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
}
