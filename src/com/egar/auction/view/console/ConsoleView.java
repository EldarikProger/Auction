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
                        e.printStackTrace();
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
                        e.printStackTrace();
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
                        }catch (UserNotFoundException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Введите имя пользоватля:");
                        name = scanner.next();
                        try {
                            printList(controlAdmin.viewListUserBids(name));
                        }catch (UserNotFoundException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        printList(controlAdmin.viewAllBids());
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("Введите имя:");
                        name = scanner.next();
                        System.out.println("Введите пароль:");
                        password = scanner.next();
                        controlAdmin.changeAdminData(name, password);
                        break;
                    case 7:
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
        System.out.println("4) Посмотреть список заявок пользователя");
        System.out.println("5) Посмотреть список всех ставок");
        System.out.println("6) Изменить свои данные");
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
            System.out.println("Выберите одно из действий");
            System.out.println("1) Посмотреть список ставок");
            System.out.println("2) Выход");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    controlGuest.viewAllBids();
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
                        printList(controlAuthorizedUser.viewUserGoodsByCategory(selectCategory()));
                        break;
                    case 3:
                        printList(controlAuthorizedUser.viewUserBids());
                        break;
                    case 4:
                        printList(controlAuthorizedUser.viewAllBids());
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Введите название товара: ");
                        String nameGood = scanner.next();
                        System.out.println("Введите описание товара: ");
                        String description = scanner.next();
                        Category category = selectCategory();
                        controlAuthorizedUser.addGood(new Good(category, nameGood, description));
                        break;
                    case 6:
                        try {
                            Good good = selectGood(controlAuthorizedUser.viewUserGoods());
                            System.out.println();
                            System.out.println("Введите min цену: ");
                            double min = scanner.nextDouble();
                            System.out.println("Введите max цену: ");
                            double max = scanner.nextDouble();
                            controlAuthorizedUser.putBid(new Bid(min, max, good));
                        }catch (UserException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        try {
                            Bid bid = selectBid(controlAuthorizedUser.viewAllBids());
                            System.out.println("Введите min цену: ");
                            double price = scanner.nextDouble();
                            if (controlAuthorizedUser.makeBet(price, bid)) {
                                System.out.println("Ставка сделана!");
                            } else {
                                System.out.println("Ставка не сделана! Поднимите цену ставки!");
                            }
                        }catch (UserException  e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 8:
                        System.out.println();
                        System.out.println("Введите имя:");
                        name = scanner.next();
                        System.out.println("Введите пароль:");
                        password = scanner.next();
                        controlAuthorizedUser.changeUserData(name, password);
                        break;
                    case 9:
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
        System.out.println("2) Посмотреть список моих товаров по категории");
        System.out.println("3) Посмотреть список моих заявок");
        System.out.println("4) Посмотреть список всех ставок");
        System.out.println("5) Добавить товар");
        System.out.println("6) Выложить заявку");
        System.out.println("7) Сделать ставку");
        System.out.println("8) Изменить свои данные");
        System.out.println("9) Выход");
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
        if(list.size()!=0) {
            System.out.println("Выберите товар:");
            int i = 1;
            for (Good c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j = scanner.nextInt();
            return list.get(j - 1);
        }
        else
            throw new UserException("Список товаров пуст!");
    }

    private Bid selectBid(List<Bid> list) throws UserException {
        System.out.println();
        if(list.size()!=0) {
            System.out.println("Выберите заявку на которую нужно сделать ставку:");
            int i = 1;
            for (Bid c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j = scanner.nextInt();
            return list.get(j - 1);
        }
        else
            throw new UserException("Список заявок пуст!");
    }

    private void printList(List list) {
        System.out.println();
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }

}
