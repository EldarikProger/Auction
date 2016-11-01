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

    public GeographicCoordinates(double degreesA,
                                 double minutesA, double secondsA, double degreesB, double minutesB, double secondsB) {
        this.degreesA = degreesA;
        this.minutesA = minutesA;
        this.secondsA = secondsA;
        this.degreesB = degreesB;
        this.minutesB = minutesB;
        this.secondsB = secondsB;
    }

    public double getAngleA(){
        return degreesA + minutesA/60 + secondsA/3600;
    }

    public double getAngleB(){
        return degreesB + minutesB/60 + secondsB/3600;
    }

    public double getDegreesA() {
        return degreesA;
    }

    public void setDegreesA(double degreesA) {
        this.degreesA = degreesA;
    }

    public double getMinutesA() {
        return minutesA;
    }

    public void setMinutesA(double minutesA) {
        this.minutesA = minutesA;
    }

    public double getSecondsA() {
        return secondsA;
    }

    public void setSecondsA(double secondsA) {
        this.secondsA = secondsA;
    }

    public double getDegreesB() {
        return degreesB;
    }

    public void setDegreesB(double degreesB) {
        this.degreesB = degreesB;
    }

    public double getMinutesB() {
        return minutesB;
    }

    public void setMinutesB(double minutesB) {
        this.minutesB = minutesB;
    }

    public double getSecondsB() {
        return secondsB;
    }

    public void setSecondsB(double secondsB) {
        this.secondsB = secondsB;
    }
}
