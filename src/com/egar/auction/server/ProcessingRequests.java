package com.egar.auction.server;

import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.exceptions.DistanceException;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserExitException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.Admin;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.requests.*;
import com.egar.auction.storage.AuctionDatabase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Processing clients requests
 */
public class ProcessingRequests {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private AuctionDatabase database;

    private DatabaseController databaseController;
    private AuthorizedUserController authorizedUserController;
    private AdminController adminController;
    private GuestController guestController;
    private DeliveryServiceController deliveryServiceController;
    private PurchaseController purchaseController;

    /**
     * Create ProcessingRequests
     *
     * @param in
     * @param out
     */
    public ProcessingRequests(ObjectInputStream in, ObjectOutputStream out, AuctionDatabase database) {
        this.in = in;
        this.out = out;
        this.database = database;
        initControllers();
    }

    private void initControllers() {
        databaseController = new DatabaseController(database);
        authorizedUserController = new AuthorizedUserController(database);
        adminController = new AdminController(database);
        guestController = new GuestController(database);
        deliveryServiceController = new DeliveryServiceController(database);
        purchaseController = new PurchaseController(database);
    }

    /**
     * Start processing
     */
    public void start() throws UserExitException, IOException {
        try {
            Request request = (Request) in.readObject();

            TypeRequest typeRequest = TypeRequest.valueOf(request.getClass().getSimpleName());// определяем тип запроса

            switch (typeRequest) {
                case AddGood:
                    request = (AddGood) request;
                    authorizedUserController.addGood(((AddGood) request).getCategory(), ((AddGood) request).getName(), ((AddGood) request).getDescription(),
                            ((AddGood) request).getMinPrice(), ((AddGood) request).getCount(), ((AddGood) request).getDay(), ((AddGood) request).getHour(),
                            ((AddGood) request).getMinutes(), ((AddGood) request).getMaxPrice(), ((AddGood) request).getOwner(), ((AddGood) request).getWeight(),
                            ((AddGood) request).getLength(), ((AddGood) request).getWidth(), ((AddGood) request).getHeight());
                    out.writeObject(true);
                    break;
                case ChangeAdminData:
                    request = (ChangeAdminData) request;
                    adminController.changeAdminData(((ChangeAdminData) request).getName(), ((ChangeAdminData) request).getPassword(),
                            ((ChangeAdminData) request).getUser());
                    Admin admin = adminController.connectToAdmin(((ChangeAdminData) request).getName(), ((ChangeAdminData) request).getPassword());
                    out.writeObject(admin);
                    break;
                case ChangeUserData:
                    request = (ChangeUserData) request;
                    authorizedUserController.changeUserData(((ChangeUserData) request).getName(), ((ChangeUserData) request).getPassword(),
                            ((ChangeUserData) request).getUser());
                    AuthorizedUser user = authorizedUserController.connectToUser(((ChangeUserData) request).getName(), ((ChangeUserData) request).getPassword());
                    out.writeObject(user);
                    break;
                case GetCommonPrice:
                    request = (GetCommonPrice) request;
                    String commonPrice = purchaseController.getCommonPriceByGood(((GetCommonPrice) request).getUser());
                    out.writeObject(commonPrice);
                    break;
                case GetPriceAllServiceForPurchase:
                    request = (GetPriceAllServiceForPurchase) request;
                    try {
                        List list = deliveryServiceController.getPriceAllServiceForPurchase(((GetPriceAllServiceForPurchase) request).getPurchase(),
                                ((GetPriceAllServiceForPurchase) request).getAuthorizedUser());
                        out.writeObject(list);
                    } catch (DistanceException e) {
                        out.writeObject(e);
                    }
                    break;
                case GetUserStatistics:
                    request = (GetUserStatistics) request;
                    List list = adminController.getUserStatistics();
                    out.writeObject(list);
                    break;
                case LogIn:
                    try {
                        request = (LogIn) request;
                        if (((LogIn) request).getPassword() == null) {
                            databaseController.createGuest(((LogIn) request).getName());
                        }
                        if (((LogIn) request).isCheckAdmin()) {
                            Admin admin1 = adminController.connectToAdmin(((LogIn) request).getName(), ((LogIn) request).getPassword());
                            out.writeObject(admin1);
                        }
                        if (!((LogIn) request).isCheckAdmin()) {
                            AuthorizedUser user1 = authorizedUserController.connectToUser(((LogIn) request).getName(),
                                    ((LogIn) request).getPassword());
                            out.writeObject(user1);
                        }
                    }catch (UserException | UserNotFoundException e){
                        out.writeObject(e);
                    }
                    break;
                case MakeBet:
                    request = (MakeBet) request;
                    authorizedUserController.makeBet(((MakeBet) request).getPrice(), ((MakeBet) request).getGood(),
                            ((MakeBet) request).getUser());
                    out.writeObject(true);
                    break;
                case SetDeliveryServiceToPurchase:
                    request = (SetDeliveryServiceToPurchase) request;
                    purchaseController.setDeliveryServiceToPurchase(((SetDeliveryServiceToPurchase) request).getPurchase(),
                            ((SetDeliveryServiceToPurchase) request).getDeliveryService(), ((SetDeliveryServiceToPurchase) request).getPrice());
                    break;
                case SetUserCoordinates:
                    request = (SetUserCoordinates) request;
                    authorizedUserController.setUserCoordinates(((SetUserCoordinates) request).getUser(), ((SetUserCoordinates) request).getDegreesA(),
                            ((SetUserCoordinates) request).getMinutesA(), ((SetUserCoordinates) request).getSecondsA(),
                            ((SetUserCoordinates) request).getDegreesB(), ((SetUserCoordinates) request).getMinutesB(),
                            ((SetUserCoordinates) request).getSecondsB());
                    AuthorizedUser user1 = authorizedUserController.connectToUser(((SetUserCoordinates) request).getUser().getName(),
                            ((SetUserCoordinates) request).getUser().getPassword());
                    out.writeObject(user1);
                    break;
                case ViewAllBids:
                    request = (ViewAllBids) request;
                    List list1 = authorizedUserController.listAllBidsByGood(((ViewAllBids) request).getUser());
                    out.writeObject(list1);
                    break;
                case ViewAllGoods:
                    request = (ViewAllGoods) request;
                    List list2 = authorizedUserController.listAllGoodsByCategory(((ViewAllGoods) request).getCategory());
                    out.writeObject(list2);
                    break;
                case ViewAllUsers:
                    request = (ViewAllUsers) request;
                    List list3 = adminController.listAllUsers();
                    out.writeObject(list3);
                    break;
                case ViewListCategory:
                    request = (ViewListCategory) request;
                    List list4 = adminController.getListCategory();
                    out.writeObject(list4);
                    break;
                case ViewListPurchase:
                    request = (ViewListPurchase) request;
                    List list5 = purchaseController.getTheGoodsPurchased(((ViewListPurchase) request).getUser());
                    out.writeObject(list5);
                    break;
                case ViewUserListOfBids:
                    request = (ViewUserListOfBids) request;
                    List list6 = authorizedUserController.listUserBids(((ViewUserListOfBids) request).getUser());
                    out.writeObject(list6);
                    break;
                case ViewUserListOfGoods:
                    request = (ViewUserListOfGoods) request;
                    List list7 = authorizedUserController.listUserGoods(((ViewUserListOfGoods) request).getUser());
                    out.writeObject(list7);
                    break;
                case Exit:
                    throw new UserExitException();
            }

        } catch ( ClassNotFoundException | UserNotFoundException | UserException e) {
            System.out.println(e.getMessage());
        }
    }
}


enum TypeRequest {
    AddGood, ChangeAdminData, ChangeUserData, GetCommonPrice, GetPriceAllServiceForPurchase,
    GetUserStatistics, LogIn, MakeBet, SetDeliveryServiceToPurchase, SetUserCoordinates, ViewUserListOfGoods,
    ViewAllBids, ViewAllGoods, ViewAllUsers, ViewListCategory, ViewListPurchase, ViewUserListOfBids, Exit;
}