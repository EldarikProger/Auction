package com.egar.auction.view;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.model.Category;
import com.egar.auction.model.DeliveryService;
import com.egar.auction.model.Purchase;
import com.egar.auction.storage.AuctionDatabase;
import com.egar.auction.view.console.MainConsole;

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
            DeliveryService service = new DeliveryService(0.1,1.2,25,100,60,0.05,2);
            storage.addDeliveryService(service);
            service = new DeliveryService(0.2,3,40,120,100,0.04,4);
            storage.addDeliveryService(service);
            service = new DeliveryService(2.2,2.2,50,200,50,0.02,5);
            storage.addDeliveryService(service);
        }

        GuestController guestController = new GuestController(storage);
        DatabaseController databaseController = new DatabaseController(storage);
        AuthorizedUserController authorizedUserController = new AuthorizedUserController(storage);
        AdminController adminController = new AdminController(storage);
        PurchaseController purchaseController = new PurchaseController(storage);
        DeliveryServiceController deliveryServiceController = new DeliveryServiceController(storage);
        new MainConsole(adminController, authorizedUserController, databaseController,
                guestController, purchaseController,deliveryServiceController).show();
    }


}