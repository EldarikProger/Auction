package com.egar.auction.view.console.itemConsole;

import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.view.console.actionConsole.UserActionConsole;

import java.util.Scanner;

/**
 * UserItemConsole is the user presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class UserItemConsole {

    private AuthorizedUser user;
    private Scanner scanner;
    private AuthorizedUserController authorizedUserController;
    private UserActionConsole actionConsole;

    /**
     * Create item and action console for user
     *
     * @param authorizedUserController manage controller for user
     * @param scanner                  to input data
     */
    public UserItemConsole(AuthorizedUserController authorizedUserController, Scanner scanner) {
        this.authorizedUserController = authorizedUserController;
        this.scanner = scanner;
    }

    /**
     * Method show view user item console
     */
    public void show() {
        try {
            user = connect();
            actionConsole = new UserActionConsole(authorizedUserController, scanner, user);
            System.out.println();
            System.out.println("Пользователь " + user.getName() + ":");
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
                        actionConsole.changeUserData();
                        break;
                    case 8:
                        user = null;
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

    private AuthorizedUser connect() throws UserNotFoundException, UserException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        return authorizedUserController.connectToUser(name, password);
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
        System.out.println("7) Ввести свои новые данные");
        System.out.println("8) Выход");
        return scanner.nextInt();
    }
}
