package com.egar.auction.controllers;

import com.egar.auction.exceptions.DistanceException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.GeographicCoordinates;

/**
 * Class measures distance between user1 and user2
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class DistanceController implements Controller {

    private DistanceController(){
    }

    /**
     * Method return double distance between users
     *
     * @param user1 AuthorizedUser and it coordinate
     * @param user2 AuthorizedUser and it coordinate
     * @return distance between users
     */
    public static double distance(AuthorizedUser user1, AuthorizedUser user2) throws DistanceException {
        GeographicCoordinates coordinates1 = user1.getCoordinates(); // AngleA - latitude
        GeographicCoordinates coordinates2 = user2.getCoordinates(); // AngleB - longitude
        if(coordinates1==null || coordinates2==null)
            throw new DistanceException();
        return 6371 * Math.acos( (Math.sin(coordinates1.getAngleA()) * Math.sin(coordinates2.getAngleA()) )
                + ( Math.cos(coordinates1.getAngleA()) * Math.cos(coordinates2.getAngleA())
                * Math.cos(coordinates1.getAngleB() - coordinates2.getAngleB()) ) );
    }

}
