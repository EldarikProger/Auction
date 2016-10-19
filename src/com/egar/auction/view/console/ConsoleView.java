package com.egar.auction.view.console;

import com.egar.auction.model.*;

import java.util.Scanner;


public class ConsoleView {
    private Scanner scanner;
    private AuctionDatabase database;

    public ConsoleView(AuctionDatabase database) {
        scanner = new Scanner(System.in);
        this.database = database;
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
                    createUser(name, password);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Введите имя:");
                    name = scanner.next();
                    System.out.println("Введите пароль:");
                    password = scanner.next();
                    createAdmin(name, password);
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
                    runFlag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }

    }

    private void workingAdmin() {
        Admin admin = connectToAdmin();
        if (admin == null) {
            System.out.println("Неверный пароль или логин!");
        } else {
            System.out.println();
            System.out.println("Администратор " + admin.getName());
            boolean nextRun = true;
            while (nextRun) {
                switch (menuAdmin()) {
                    case 1:
                        System.out.println();
                        for (AuthorizedUser user : database.getAuthorizedUsers()) {
                            System.out.println("Пользователь " + user.toString());
                        }
                        for (Admin user : database.getAdmins()) {
                            System.out.println("Администратор " + user.toString());
                        }
                        break;
                    case 2:
                        System.out.println();
                        AuthorizedUser user = selectUser();
                        System.out.println();
                        for (Good good : user.getMyGoods()) {
                            System.out.println(good.toString());
                        }
                        break;
                    case 3:
                        System.out.println();
                        AuthorizedUser selectUser = selectUser();
                        System.out.println();
                        for (Bid bid : selectUser.getMyBids()) {
                            System.out.println(bid.toString());
                        }
                        break;
                    case 4:
                        for (Bid bid : database.getAllBids()) {
                            System.out.println(bid.toString());
                        }
                        break;
                    case 5:
                        nextRun = false;
                        break;
                    default:
                        System.out.println("Вы выбрали несуществующий вариант!");
                }
            }
        }
    }

    private AuthorizedUser selectUser() {
        int i = 1;
        System.out.println("Выберите пользователя: ");
        for (AuthorizedUser user : database.getAuthorizedUsers()) {
            System.out.println((i++) + ") Пользователь " + user.getName());
        }
        int j = scanner.nextInt();
        return database.getAuthorizedUsers().get(j - 1);
    }

    private int menuAdmin() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список пользователей");
        System.out.println("2) Посмотреть список товаров пользователя");
        System.out.println("3) Посмотреть список заявок пользователя");
        System.out.println("4) Посмотреть список всех ставок");
        System.out.println("5) Выход");
        return scanner.nextInt();
    }

    private Admin connectToAdmin() {
        String name;
        String password;
        Admin admin = null;
        System.out.println();
        System.out.println("Введите имя:");
        name = scanner.next();
        System.out.println("Введите пароль:");
        password = scanner.next();
        for (Admin user : database.getAdmins()) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                admin = user;
            }
        }
        return admin;
    }

    private void workingGuest() {
        System.out.println("Введите имя:");
        String name = scanner.next();
        Guest guest = new Guest(name);
        System.out.println();
        System.out.println("Гость " + guest.getName());
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите одно из действий");
            System.out.println("1) Посмотреть список ставок");
            System.out.println("2) Выход");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    for (Bid bid : database.getAllBids()) {
                        System.out.println(bid.toString());
                    }
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }
    }

    private void workingUser() {
        AuthorizedUser curUser = connectToUser();
        if (curUser == null) {
            System.out.println("Неверный пароль или логин!");
        } else {
            System.out.println();
            System.out.println("Пользователь " + curUser.getName());
            boolean nextRun = true;
            while (nextRun) {
                switch (menuUser()) {
                    case 1:
                        for (Good good : curUser.getMyGoods()) {
                            System.out.println(good.toString());
                        }
                        break;
                    case 2:
                        Category cat = selectCategory();
                        for (Good good : curUser.getMyGoods()) {
                            if (good.getCategory() == cat)
                                System.out.println(good.toString());
                        }
                        break;
                    case 3:
                        for (Bid bid : curUser.getMyBids()) {
                            System.out.println(bid.toString());
                        }
                        break;
                    case 4:
                        for (Bid bid : database.getAllBids()) {
                            System.out.println(bid.toString());
                        }
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        nextRun = false;
                        break;
                    default:
                        System.out.println("Вы выбрали несуществующий вариант!");
                }
            }
        }
    }


    private Category selectCategory() {
        System.out.println();
        System.out.println("Выберите категорию");
        int i = 1;
        for (Category c : Category.values()) {
            System.out.println((i++) + ") " + c);
        }
        int j = scanner.nextInt();
        return Category.values()[j - 1];
    }

    private int mainMenu() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Создать пользователя");
        System.out.println("2) Создать Администратора");
        System.out.println("3) Войти под пользователем");
        System.out.println("4) Войти гостем");
        System.out.println("5) Войти Администратором");
        System.out.println("6) Выход");
        return scanner.nextInt();
    }


    private AuthorizedUser connectToUser() {
        String name;
        String password;
        AuthorizedUser curUser = null;
        System.out.println();
        System.out.println("Введите имя:");
        name = scanner.next();
        System.out.println("Введите пароль:");
        password = scanner.next();
        for (AuthorizedUser user : database.getAuthorizedUsers()) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                curUser = user;
            }
        }
        return curUser;
    }

    private int menuUser() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список моих товаров");
        System.out.println("2) Посмотреть список моих товаров по категории");
        System.out.println("3) Посмотреть список моих заявок");
        System.out.println("4) Посмотреть список всех ставок");
        System.out.println("5) Добавить товар");
        System.out.println("6) Выложить заявку");
        System.out.println("7) Сделать ставку");
        System.out.println("8) Выход");
        return scanner.nextInt();
    }

    private void createUser(String name, String password) {
        database.addAuthorizedUser(new AuthorizedUser(name, password));
    }

    private void createAdmin(String name, String password) {
        database.addAdmin(new Admin(name, password));
    }


}
