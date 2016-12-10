package com.egar.auction.view.console.itemConsole;

import com.egar.auction.controllers.DeliveryServiceController;
import com.egar.auction.controllers.PurchaseController;
import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Purchase;
import com.egar.auction.model.User;
import com.egar.auction.view.console.actionConsole.UserActionConsole;

import java.util.Scanner;

/**
 * UserItemConsole is the user presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class UserItemConsole {

    private Scanner scanner;
    private AuthorizedUserController authorizedUserController;
    private UserActionConsole actionConsole;
    private AuthorizedUser myUser;
    ItemConsoleUserPurchase userPurchase;

    /**
     * Create item and action console for user
     *
     * @param authorizedUserController manage controller for user
     * @param scanner                  to input data
     */
    public UserItemConsole(AuthorizedUserController authorizedUserController, Scanner scanner,
                           PurchaseController purchaseController, DeliveryServiceController deliveryServiceController) {
        this.authorizedUserController = authorizedUserController;
        this.scanner = scanner;
        actionConsole = new UserActionConsole(authorizedUserController, scanner, null);
        userPurchase = new ItemConsoleUserPurchase(null, scanner, purchaseController, deliveryServiceController);
    }

    /**
     * Method show view user item console
     */
    public void show() {
        try {
            connect();
            actionConsole.setMyUser(myUser);
            userPurchase.setMyUser(myUser);
            System.out.println();
            System.out.println("Пользователь " + myUser.getName() + ":");
            boolean nextRun = true;
            while (nextRun) {
                switch (menuUser()) {
                    case 1:
                        actionConsole.viewListUserGoods();
                        break;
                    case 2:
                        actionConsole.viewListUserBids();
                        break;
                    case 3:
                        actionConsole.viewAllGoodsByCategory();
                        break;
                    case 4:
                        actionConsole.viewAllBidsByGood();
                        break;
                    case 5:
                        actionConsole.addGood();
                        break;
                    case 6:
                        actionConsole.makeBet();
                        break;
                    case 7:
                        userPurchase.show();
                        break;
                    case 8:
                        actionConsole.changeUserData();
                        break;
                    case 9:
                        myUser = null;
                        nextRun = false;
                        break;
                    default:
                        System.out.println("Вы выбрали несуществующий вариант!");
                }
            }
        } catch (UserNotFoundException | UserException e) {
            System.out.println(e.getMessage());
        }
    }

    private void connect() throws UserNotFoundException, UserException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        myUser = authorizedUserController.connectToUser(name, password);
    }

    private int menuUser() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список моих товаров");
        System.out.println("2) Посмотреть список моих ставок");
        System.out.println("3) Посмотреть список всех товаров по категории");
        System.out.println("4) Посмотреть список всех ставок по товару");
        System.out.println("5) Добавить товар");
        System.out.println("6) Сделать ставку");
        System.out.println("7) Мои покупки");
        System.out.println("8) Ввести свои новые данные");
        System.out.println("9) Выход");
        return scanner.nextInt();
    }
}
