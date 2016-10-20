package com.egar.auction.view.console;


import com.egar.auction.controller.*;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    private ControlAdmin controlAdmin;
    private ControlAuthorizedUser controlAuthorizedUser;
    private ControlDatabase controlDatabase;
    private ControlGuest controlGuest;

    public ConsoleView(ControlAdmin controlAdmin, ControlAuthorizedUser controlAuthorizedUser, ControlDatabase controlDatabase, ControlGuest controlGuest) {
        this.controlAdmin = controlAdmin;
        this.controlAuthorizedUser = controlAuthorizedUser;
        this.controlDatabase = controlDatabase;
        this.controlGuest = controlGuest;
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
                    try {
                        controlDatabase.createAuthorizedUser(name, password);
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    try {
                        controlDatabase.createAdmin(name, password);
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
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
                    controlDatabase.deleteAuthorizedUser(name, password);
                    break;
                case 7:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    controlDatabase.deleteAdmin(name, password);
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
            controlAdmin.connectToAdmin(name, password);
            System.out.println();
            System.out.println("Администратор " + controlAdmin.getAdmin().getName());
            boolean nextRun = true;
            while (nextRun) {
                switch (menuAdmin()) {
                    case 1:
                        printList(controlAdmin.viewListUsers());
                        break;
                    case 2:
                        printList(controlAdmin.viewListAdmins());
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Введите имя пользоватля:");
                        name = scanner.next();
                        try {
                            printList(controlAdmin.viewListUserGoods(name));
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Введите имя пользоватля:");
                        name = scanner.next();
                        try {
                            printList(controlAdmin.viewListUserBids(name));
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        printList(controlAdmin.viewAllGoodsByCategory(selectCategory()));
                        break;
                    case 6:
                        List<Good> list = controlAdmin.viewAllGoodsByCategory(selectCategory());
                        try {
                            printList(controlAdmin.viewAllBidsByGood(selectGood(list)));
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
                        controlAdmin.changeAdminData(name, password);
                        break;
                    case 8:
                        controlAdmin.setAdmin(null);
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
        System.out.println("3) Посмотреть список товаров пользователя");
        System.out.println("4) Посмотреть список ставок пользователя");
        System.out.println("5) Посмотреть список товаров по категории");
        System.out.println("6) Посмотреть список всех ставок по товару");
        System.out.println("7) Изменить свои данные");
        System.out.println("8) Выход");
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
                    printList(controlGuest.viewAllGoodsByCategory(selectCategory()));
                    break;
                case 2:
                    List<Good> list = controlGuest.viewAllGoodsByCategory(selectCategory());
                    try {
                        printList(controlGuest.viewAllBidsByGood(selectGood(list)));
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
            controlAuthorizedUser.connectToUser(name, password);
            System.out.println();
            System.out.println("Пользователь " + controlAuthorizedUser.getUser().getName());
            boolean nextRun = true;
            while (nextRun) {
                switch (menuUser()) {
                    case 1:
                        printList(controlAuthorizedUser.viewUserGoods());
                        break;
                    case 2:
                        printList(controlAuthorizedUser.viewUserBids());
                        break;
                    case 3:
                        printList(controlAuthorizedUser.viewAllGoodsByCategory(selectCategory()));
                        break;
                    case 4:
                        List<Good> list = controlAuthorizedUser.viewAllGoodsByCategory(selectCategory());
                        try {
                            printList(controlAuthorizedUser.viewAllBidsByGood(selectGood(list)));
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
                        Category category = selectCategory();
                        controlAuthorizedUser.addGood(category, nameGood, description, minPrice, maxPrice);
                        break;
                    case 6:
                        List<Good> goodList = controlAuthorizedUser.viewAllGoodsByCategory(selectCategory());
                        try {
                            Good good = selectGood(goodList);
                            System.out.println();
                            System.out.println("Введите цену(ставку): ");
                            double price = scanner.nextDouble();
                            controlAuthorizedUser.makeBet(price, good);
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
                        controlAuthorizedUser.changeUserData(name, password);
                        break;
                    case 8:
                        controlAuthorizedUser.setUser(null);
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
        System.out.println("7) Изменить свои данные");
        System.out.println("8) Выход");
        return scanner.nextInt();
    }

    private Category selectCategory() {
        System.out.println();
        System.out.println("Выберите категорию:");
        int i = 1;
        for (Category c : Category.values()) {
            System.out.println((i++) + ") " + c);
        }
        int j = scanner.nextInt();
        return Category.values()[j - 1];
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
            return list.get(j - 1);
        } else
            throw new UserException("Список товаров пуст!");
    }

    private void printList(List list) {
        System.out.println();
        if (list.size() == 0)
            System.out.println("Список пуст!");
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }

}
