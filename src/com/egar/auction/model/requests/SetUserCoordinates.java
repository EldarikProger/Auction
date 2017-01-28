package com.egar.auction.model.requests;

import com.egar.auction.model.AuthorizedUser;

import java.io.Serializable;

/**
 * Team to set user coordinates
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class SetUserCoordinates implements Request, Serializable {

    private AuthorizedUser user;
    private double degreesA; //latitude
    private double minutesA;
    private double secondsA;
    private double degreesB; //longitude
    private double minutesB;
    private double secondsB;

    /**
     * @param degreesA degrees latitude
     * @param minutesA minutes latitude
     * @param secondsA seconds latitude
     * @param degreesB degrees longitude
     * @param minutesB minutes longitude
     * @param secondsB seconds longitude
     * @see SetUserCoordinates#SetUserCoordinates()
     */
    public SetUserCoordinates(AuthorizedUser user, double degreesA,
                              double minutesA, double secondsA, double degreesB, double minutesB, double secondsB) {
        this.user = user;
        this.degreesA = degreesA;
        this.minutesA = minutesA;
        this.secondsA = secondsA;
        this.degreesB = degreesB;
        this.minutesB = minutesB;
        this.secondsB = secondsB;
    }

    /**
     * getUser
     * @return user
     */
    public AuthorizedUser getUser() {
        return user;
    }

    /**
     * setUser
     * @param user
     */
    public void setUser(AuthorizedUser user) {
        this.user = user;
    }

    /**
     * Create request to set coordinates
     */
    public SetUserCoordinates() {

    }

    /**
     * Return degrees latitude
     *
     * @return degrees latitude
     */
    public double getDegreesA() {
        return degreesA;
    }

    /**
     * Put degrees latitude
     *
     * @param degreesA degrees latitude
     */
    public void setDegreesA(double degreesA) {
        this.degreesA = degreesA;
    }

    /**
     * Return minutes latitude
     *
     * @return minutes latitude
     */
    public double getMinutesA() {
        return minutesA;
    }

    /**
     * Put minutes latitude
     *
     * @param minutesA minutes latitude
     */
    public void setMinutesA(double minutesA) {
        this.minutesA = minutesA;
    }

    /**
     * Return seconds latitude
     *
     * @return seconds latitude
     */
    public double getSecondsA() {
        return secondsA;
    }

    /**
     * Put seconds latitude
     *
     * @param secondsA seconds latitude
     */
    public void setSecondsA(double secondsA) {
        this.secondsA = secondsA;
    }

    /**
     * Return degrees longitude
     *
     * @return degrees longitude
     */
    public double getDegreesB() {
        return degreesB;
    }

    /**
     * Put degrees longitude
     *
     * @param degreesB degrees longitude
     */
    public void setDegreesB(double degreesB) {
        this.degreesB = degreesB;
    }

    /**
     * Return minutes longitude
     *
     * @return minutes longitude
     */
    public double getMinutesB() {
        return minutesB;
    }

    /**
     * Put minutes longitude
     *
     * @param minutesB minutes longitude
     */
    public void setMinutesB(double minutesB) {
        this.minutesB = minutesB;
    }

    /**
     * Return seconds longitude
     *
     * @return seconds longitude
     */
    public double getSecondsB() {
        return secondsB;
    }

    /**
     * Put seconds longitude
     *
     * @param secondsB seconds longitude
     */
    public void setSecondsB(double secondsB) {
        this.secondsB = secondsB;
    }

}
