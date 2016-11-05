package com.egar.auction.view.first_console;

import com.egar.auction.controllers.*;
import com.egar.auction.controllers.user_controllers.AdminController;
import com.egar.auction.controllers.user_controllers.AuthorizedUserController;
import com.egar.auction.controllers.user_controllers.GuestController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.*;

import java.util.List;
import java.util.Scanner;

/**
 * Class is the user presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class ConsoleView {

    private Scanner scanner;
    private AdminController adminController;
    private AuthorizedUserController authorizedUserController;
    private DatabaseController databaseController;
    private GuestController guestController;

    /**
     * Create and show ConsoleView
     *
     * @param adminController UserController
     * @param authorizedUserController UserController
     * @param databaseController Controller
     * @param guestController UserController
     */
    public ConsoleView(AdminController adminController, AuthorizedUserController authorizedUserController, DatabaseController databaseController, GuestController guestController) {
        this.adminController = adminController;
        this.authorizedUserController = authorizedUserController;
        this.databaseController = databaseController;
        this.guestController = guestController;
        scanner = new Scanner(System.in);
        start();
    }

    private void start() {
        boolean runFlag = true;
        String name;
        String password;
        while (runFlag) {
            switch (mainMenu()) {

                case 1:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    databaseController.createAuthorizedUser(name, password);
                    System.out.println("Пользователь создан!");
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    databaseController.createAdmin(name, password);
                    System.out.println("Администратор создан!");
                    break;
                case 3:
                    workingUser();
                    break;
                case 4:
                    workingGuest();
                    break;
                case 5:
                    workingAdmin();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    databaseController.deleteAuthorizedUser(name, password);
                    break;
                case 7:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    databaseController.deleteAdmin(name, password);
                    break;
                case 8:
                    runFlag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }

    }

    private int mainMenu() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Создать пользователя");
        System.out.println("2) Создать администратора");
        System.out.println("3) Войти под пользователем");
        System.out.println("4) Войти гостем");
        System.out.println("5) Войти администратором");
        System.out.println("6) Удалить пользователя");
        System.out.println("7) Удалить администратора");
        System.out.println("8) Выход");
        return scanner.nextInt();
    }

    private void workingAdmin() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        try {
            adminController.connectToAdmin(name, password);
            System.out.println();
            System.out.println("Администратор " + adminController.getAdmin().getName());
            boolean nextRun = true;
            while (nextRun) {
                switch (menuAdmin()) {
                    case 1:
                        printList(adminController.listAllUsers());
                        break;
                    case 2:
                        printList(adminController.listAllAdmins());
                        break;
                    case 3:
                        printList(adminController.getUserStatistics());
                        break;
                    case 4:
                        try {
                            printList(adminController.listAllGoodsByCategory(selectCategory()));

                        } catch (UserException e) {
                            e.getMessage();
                        }
                        break;
                    case 5:
                        try {
                            List<Good> list = adminController.listAllGoodsByCategory(selectCategory());
                            printList(adminController.listAllBidsByGood(selectGood(list)));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("Введите имя:");
                        name = scanner.next();
                        System.out.println("Введите пароль:");
                        password = scanner.next();
                        adminController.changeAdminData(name, password);
                        break;
                    case 7:
                        adminController.setAdmin(null);
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

    private int menuAdmin() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список пользователей");
        System.out.println("2) Посмотреть список всех администраторов");
        System.out.println("3) Посмотреть статистику по пользователям");
        System.out.println("4) Посмотреть список товаров по категории");
        System.out.println("5) Посмотреть список всех ставок по товару");
        System.out.println("6) Ввести свои новые данные");
        System.out.println("7) Выход");
        return scanner.nextInt();
    }

    private void workingGuest() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        Guest guest = new Guest(name);
        System.out.println();
        System.out.println("Гость " + guest.getName());
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("Выберите одно из действий");
            System.out.println("1) Посмотреть список товаров по категории");
            System.out.println("2) Посмотреть список всех ставок по товару");
            System.out.println("3) Выход");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    try {
                        printList(guestController.listAllGoodsByCategory(selectCategory()));
                    } catch (UserException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    List<Good> list = null;
                    try {
                        list = guestController.listAllGoodsByCategory(selectCategory());
                    } catch (UserException e) {
                        e.getMessage();
                    }
                    try {
                        printList(guestController.listAllBidsByGood(selectGood(list)));
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }
    }

    private void workingUser() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        try {
            authorizedUserController.connectToUser(name, password);
            System.out.println();
            System.out.println("Пользователь " + authorizedUserController.getUser().getName());
            boolean nextRun = true;
            while (nextRun) {
                switch (menuUser()) {
                    case 1:
                        printList(authorizedUserController.listUserGoods());
                        break;
                    case 2:
                        printList(authorizedUserController.listUserBids());
                        break;
                    case 3:
                        try {
                            printList(authorizedUserController.listAllGoodsByCategory(selectCategory()));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            List<Good> list = authorizedUserController.listAllGoodsByCategory(selectCategory());
                            printList(authorizedUserController.listAllBidsByGood(selectGood(list)));
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Введите название товара: ");
                        String nameGood = scanner.next();
                        System.out.println("Введите описание товара: ");
                        String description = scanner.next();
                        System.out.println("Введите min цену: ");
                        double minPrice = scanner.nextDouble();
                        System.out.println("Введите max цену: ");
                        double maxPrice = scanner.nextDouble();
                        try {
                            Category category = selectCategory();
                            authorizedUserController.addGood(category, nameGood, description, minPrice, maxPrice);
                            System.out.println("Товар добавлен!");
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            List<Good> goodList = authorizedUserController.listAllGoodsByCategory(selectCategory());
                            Good good = selectGood(goodList);
                            System.out.println();
                            System.out.println("Введите цену(ставку): ");
                            double price = scanner.nextDouble();
                            authorizedUserController.makeBet(price, good);
                            System.out.println("Ставка сделана!");
                        } catch (UserException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println();
                        System.out.println("Введите имя:");
                        name = scanner.next();
                        System.out.println("Введите пароль:");
                        password = scanner.next();
                        authorizedUserController.changeUserData(name, password);
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

    private Category selectCategory() throws UserException {
        System.out.println();
        System.out.println("Выберите категорию:");
        List<Category> list = authorizedUserController.getListCategory();
        int i = 1;
        for (Category c : list) {
            System.out.println((i++) + ") " + c.getName());
        }
        int j = scanner.nextInt();
        if (j <= 0 || j > list.size())
            throw new UserException("Вы выбрали не существующую категорию!");
        return list.get(j-1);
    }

    private Good selectGood(List<Good> list) throws UserException {
        System.out.println();
        if (list.size() != 0) {
            System.out.println("Выберите товар:");
            int i = 1;
            for (Good c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j = scanner.nextInt();
            if (j <= 0 || j > list.size())
                throw new UserException("Вы выбрали не существующую товар!");
            return list.get(j - 1);
        } else
            throw new UserException("Список товаров пуст!");
    }

    private void printList(List list) {
        System.out.println();
        if (list.size() == 0)
            System.out.println("Список пуст!");
        int i = 1;
        for (Object obj : list) {
            System.out.println((i++) + ") " + obj.toString());
        }
    }

}
