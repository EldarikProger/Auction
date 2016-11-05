package com.egar.auction.view.console.item_console;

import com.egar.auction.controllers.user_controllers.AuthorizedUserController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.view.console.action_console.UserActionConsole;

import java.util.Scanner;

public class UserItemConsole {

    private Scanner scanner;
    private AuthorizedUserController authorizedUserController;
    private UserActionConsole actionConsole;


    public UserItemConsole(AuthorizedUserController authorizedUserController, Scanner scanner) {
        this.authorizedUserController = authorizedUserController;
        this.scanner = scanner;
        actionConsole = new UserActionConsole(authorizedUserController, scanner);
    }


    public void show() {
        try {
            connect();
            System.out.println();
            System.out.println("Пользователь " + authorizedUserController.getUser().getName() + ":");
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
                        authorizedUserController.setUser(null);
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
        authorizedUserController.connectToUser(name, password);
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
