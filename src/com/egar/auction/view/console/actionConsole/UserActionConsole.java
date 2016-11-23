package com.egar.auction.view.console.actionConsole;


import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

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
    private Scanner scanner;
    private AuthorizedUser myUser;

    /**
     * Create UserActionConsole for presentation it actions
     *
     * @param authorizedUserController controller for manage
     * @param scanner                  to input data
     */
    public UserActionConsole(AuthorizedUserController authorizedUserController, Scanner scanner, AuthorizedUser user) {
        this.scanner = scanner;
        this.authorizedUserController = authorizedUserController;
        this.myUser = user;
    }

    /**
     * Put user for manage
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
        System.out.println();
        System.out.println("Введите название товара: ");
        String nameGood = scanner.next();
        System.out.println("Введите описание товара: ");
        String description = scanner.next();
        System.out.println("Введите min цену: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Введите max цену: ");
        double maxPrice = scanner.nextDouble();
        System.out.println("Сколько дней, часов, минут длится аукцион для товара: ");
        int day = scanner.nextInt();
        int hour = scanner.nextInt();
        int minutes = scanner.nextInt();
        System.out.println("Введите длину, ширину, высоту товара: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        System.out.println("Введите массу товара: ");
        double weight = scanner.nextDouble();
        System.out.println("Введите количество вашего товара: ");
        int count = scanner.nextInt();
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
            double price = scanner.nextDouble();
            authorizedUserController.makeBet(price, good,myUser);
            System.out.println("Ставка сделана!");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method change user data
     */
    public void changeUserData() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        authorizedUserController.changeUserData(name, password,myUser);
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
