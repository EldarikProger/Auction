package com.egar.auction.view.console.actionConsole;


import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Category;
import com.egar.auction.model.GeographicCoordinates;
import com.egar.auction.model.Good;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * UserActionConsole is the action user
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class UserActionConsole {

    private AuthorizedUserController authorizedUserController;
    private BufferedReader br;
    private AuthorizedUser myUser;

    /**
     * Create UserActionConsole for presentation it actions
     *
     * @param authorizedUserController controller for manage
     * @param br                       to input data
     */
    public UserActionConsole(AuthorizedUserController authorizedUserController, BufferedReader br, AuthorizedUser user) {
        this.br = br;
        this.authorizedUserController = authorizedUserController;
        this.myUser = user;
    }

    /**
     * Put user for manage
     *
     * @param myUser
     */
    public void setMyUser(AuthorizedUser myUser) {
        this.myUser = myUser;
    }

    /**
     * Method print list their goods
     */
    public void viewListUserGoods() {
        printList(authorizedUserController.listUserGoods(myUser));
    }

    /**
     * Method print list their bids
     */
    public void viewListUserBids() {
        printList(authorizedUserController.listUserBids(myUser));
    }

    /**
     * Method print list all goods
     */
    public void viewAllGoodsByCategory() {
        try {
            printList(authorizedUserController.listAllGoodsByCategory(selectCategory()));
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print list all bids
     */
    public void viewAllBidsByGood() {
        try {
            List<Good> list = authorizedUserController.listAllGoodsByCategory(selectCategory());
            printList(authorizedUserController.listAllBidsByGood(selectGood(list)));
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method add good to user
     */
    public void addGood() {
        String nameGood, description;
        double minPrice, maxPrice, length, width, height, weight;
        int day, hour, minutes, count;
        while (true) {
            try {
                System.out.println();
                System.out.println("Введите название товара: ");
                nameGood = br.readLine();
                System.out.println("Введите описание товара: ");
                description = br.readLine();
                System.out.println("Введите min цену: ");
                minPrice = Double.parseDouble(br.readLine());
                System.out.println("Введите max цену: ");
                maxPrice = Double.parseDouble(br.readLine());
                System.out.println("Сколько дней, часов и минут длится аукцион для товара: ");
                day = Integer.parseInt(br.readLine());
                hour = Integer.parseInt(br.readLine());
                minutes = Integer.parseInt(br.readLine());
                System.out.println("Введите длину, ширину, высоту товара: ");
                length = Double.parseDouble(br.readLine());
                width = Double.parseDouble(br.readLine());
                height = Double.parseDouble(br.readLine());
                System.out.println("Введите массу товара: ");
                weight = Double.parseDouble(br.readLine());
                System.out.println("Введите количество вашего товара: ");
                count = Integer.parseInt(br.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Неккоректный ввод данных, введите заново:");
            }
        }

        try {
            Category category = selectCategory();
            authorizedUserController.addGood(category, nameGood, description, minPrice, count, day, hour, minutes, maxPrice,
                    myUser, weight, length, width, height);
            System.out.println("Товар добавлен!");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method make bet (add bid to user)
     */
    public void makeBet() {
        try {
            List<Good> goodList = authorizedUserController.listAllGoodsByCategory(selectCategory());
            Good good = selectGood(goodList);
            System.out.println();
            System.out.println("Введите цену(ставку): ");
            double price;
            while (true) {
                try {
                    price = Double.parseDouble(br.readLine());
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Вы ввели не корректные данные, введите число заново");
                }
            }
            authorizedUserController.makeBet(price, good, myUser);
            System.out.println("Ставка сделана!");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method change user data
     */
    public void changeUserData() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        authorizedUserController.changeUserData(name, password, myUser);
    }

    public void addUserCoordinate(){
        try {
            System.out.println("Введите широту и долготу: ");
            System.out.println("Введите градусы, минуты, секунды широты: ");
            double degreesA = Double.parseDouble(br.readLine());
            double minutesA = Double.parseDouble(br.readLine());
            double secondsA = Double.parseDouble(br.readLine());
            System.out.println("Введите градусы, минуты, секунды долготы: ");
            double degreesB = Double.parseDouble(br.readLine());
            double minutesB = Double.parseDouble(br.readLine());
            double secondsB = Double.parseDouble(br.readLine());
            myUser.setCoordinates(new GeographicCoordinates(degreesA,minutesA,secondsA,degreesB,minutesB,secondsB));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Вы ввели некоректные данные!");
        }
    }


    private Good selectGood(List<Good> list) throws UserException {
        System.out.println();
        if (list.size() != 0) {
            System.out.println("Выберите товар:");
            int i = 1;
            for (Good c : list) {
                System.out.println((i++) + ") " + c.toString());
            }
            int j;
            while (true) {
                try {
                    j = Integer.parseInt(br.readLine());
                    break;
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Вы ввели не число, введите число заново");
                }
            }
            if (j <= 0 || j > list.size())
                throw new UserException("Вы выбрали не существующую товар!");
            return list.get(j - 1);
        } else
            throw new UserException("Список товаров пуст!");
    }

    private Category selectCategory() throws UserException {
        System.out.println();
        System.out.println("Выберите категорию:");
        List<Category> list = authorizedUserController.getListCategory();
        int i = 1;
        for (Category c : list) {
            System.out.println((i++) + ") " + c.getName());
        }
        int j;
        while (true) {
            try {
                j = Integer.parseInt(br.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Вы ввели не число, введите число заново");
            }
        }
        if (j <= 0 || j > list.size())
            throw new UserException("Вы выбрали не существующую категорию!");
        return list.get(j - 1);
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
