package com.egar.auction.model;

/**
 * GeographicCoordinates describe user coordinates: longitude latitude
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class GeographicCoordinates {

    private double degreesA; //latitude
    private double minutesA;
    private double secondsA;
    private double degreesB; //longitude
    private double minutesB;
    private double secondsB;

    /**
     * Create coordinate
     * @param degreesA degrees latitude
     * @param minutesA minutes latitude
     * @param secondsA seconds latitude
     * @param degreesB degrees longitude
     * @param minutesB minutes longitude
     * @param secondsB seconds longitude
     */
    public GeographicCoordinates(double degreesA,
                                 double minutesA, double secondsA, double degreesB, double minutesB, double secondsB) {
        this.degreesA = degreesA;
        this.minutesA = minutesA;
        this.secondsA = secondsA;
        this.degreesB = degreesB;
        this.minutesB = minutesB;
        this.secondsB = secondsB;
    }

    /**
     * Return angle latitude
     * @return angle latitude
     */
    public double getAngleA(){
        return degreesA + minutesA/60 + secondsA/3600;
    }

    /**
     * Return angle longitude
     * @return angle longitude
     */
    public double getAngleB(){
        return degreesB + minutesB/60 + secondsB/3600;
    }

    /**
     * Return degrees latitude
     * @return degrees latitude
     */
    public double getDegreesA() {
        return degreesA;
    }

    /**
     * Put degrees latitude
     * @param degreesA degrees latitude
     */
    public void setDegreesA(double degreesA) {
        this.degreesA = degreesA;
    }

    /**
     * Return minutes latitude
     * @return minutes latitude
     */
    public double getMinutesA() {
        return minutesA;
    }

    /**
     *  Put minutes latitude
     * @param minutesA minutes latitude
     */
    public void setMinutesA(double minutesA) {
        this.minutesA = minutesA;
    }

    /**
     * Return seconds latitude
     * @return seconds latitude
     */
    public double getSecondsA() {
        return secondsA;
    }

    /**
     * Put seconds latitude
     * @param secondsA seconds latitude
     */
    public void setSecondsA(double secondsA) {
        this.secondsA = secondsA;
    }

    /**
     * Return degrees longitude
     * @return degrees longitude
     */
    public double getDegreesB() {
        return degreesB;
    }

    /**
     * Put degrees longitude
     * @param degreesB degrees longitude
     */
    public void setDegreesB(double degreesB) {
        this.degreesB = degreesB;
    }

    /**
     * Return minutes longitude
     * @return minutes longitude
     */
    public double getMinutesB() {
        return minutesB;
    }

    /**
     *  Put minutes longitude
     * @param minutesB minutes longitude
     */
    public void setMinutesB(double minutesB) {
        this.minutesB = minutesB;
    }

    /**
     * Return seconds longitude
     * @return seconds longitude
     */
    public double getSecondsB() {
        return secondsB;
    }

    /**
     * Put seconds longitude
     * @param secondsB seconds longitude
     */
    public void setSecondsB(double secondsB) {
        this.secondsB = secondsB;
    }
}
