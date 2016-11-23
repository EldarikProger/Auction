package com.egar.auction.view;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.model.*;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.console.MainConsole;

import java.util.Date;

/**
 * Class Module create database and all controllers.
 * Module crate and show view. Module is the entry point of the program.
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Module {

    /**
     * This is the entry point of the program.
     *
     * @param arg arguments with which program started
     */
    public static void main(String[] arg) {
        System.out.println("Это программа Аукцион!");

        AuctionDatabase storage = new AuctionDatabase();

        {
            Category category = new Category("CLOTHING");
            storage.addCategory(category);
            category = new Category("SHOES");
            storage.addCategory(category);
            category = new Category("TELEPHONE");
            storage.addCategory(category);
            category = new Category("AUTO");
            storage.addCategory(category);
            category = new Category("JEWELRY");
            storage.addCategory(category);
            category = new Category("WATCH");
            storage.addCategory(category);
            category = new Category("COMPUTER_EQUIPMENT");
            storage.addCategory(category);
            category = new Category("ELECTRONICS");
            storage.addCategory(category);
            category = new Category("SPORTS_WEAR");
            storage.addCategory(category);
            category = new Category("BUILDING_TOOLS");
            storage.addCategory(category);
            category = new Category("FURNITURE");
            storage.addCategory(category);
            category = new Category("FOOD");
            storage.addCategory(category);
            category = new Category("MUSICAL_INSTRUMENTS");
            storage.addCategory(category);
        }

        {
            DeliveryService service = new DeliveryService(10,12,25,100,60,0.5,2);
            storage.addDeliveryService(service);
            service = new DeliveryService(2,30,40,120,100,0.4,4);
            storage.addDeliveryService(service);
            service = new DeliveryService(22,22,50,200,50,0.2,5);
            storage.addDeliveryService(service);
        }




        GuestController guestController = new GuestController(storage);
        DatabaseController databaseController = new DatabaseController(storage);
        AuthorizedUserController authorizedUserController = new AuthorizedUserController(storage);
        AdminController adminController = new AdminController(storage);
        PurchaseController purchaseController = new PurchaseController(storage);
        DeliveryServiceController deliveryServiceController = new DeliveryServiceController(storage);

        //тест
        AuthorizedUser user = new AuthorizedUser("q","1",22);
        storage.addAuthorizedUser(user);
        authorizedUserController.addGood(storage.getCategories().get(0),"qw","qw",1,2,0,0,1,200,user,10,2,3,4);

        System.out.println(storage.getAllGoods().get(0).isGoodSold());
        try {
            Thread.sleep(65000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(storage.getAllGoods().get(0).isGoodSold());

        new MainConsole(adminController, authorizedUserController, databaseController,
                guestController, purchaseController,deliveryServiceController).show();
    }


}