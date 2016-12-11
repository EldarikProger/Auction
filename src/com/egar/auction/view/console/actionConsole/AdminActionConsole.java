package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Admin;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.List;
import java.util.Scanner;

/**
 * AdminActionConsole is the action admin
 *
 * @version 1.1
 * @author Eldar Ziatdinov
 */
public class AdminActionConsole {

    private Admin admin;
    private Scanner scanner;
    private AdminController adminController;

    /**
     * Create AdminActionConsole for presentation it actions
     * @param adminController controller for manage
     * @param scanner to input data
     */
    public AdminActionConsole(AdminController adminController, Scanner scanner,Admin admin) {
        this.adminController = adminController;
        this.scanner = scanner;
        this.admin = admin;
    }

    /**
     * Method print list users
     */
    public void viewListUsers(){
        printList(adminController.listAllUsers());
    }

    /**
     * Method print list admins
     */
    public void viewListAdmin(){
        printList(adminController.listAllAdmins());
    }

    /**
     * Method print users statistics
     */
    public void viewStatisticByUsers(){
        printList(adminController.getUserStatistics());
    }

    /**
     * Method print list goods
     */
    public void viewAllGoodsByCategory(){
        try {
            printList(adminController.listAllGoodsByCategory(selectCategory()));

        } catch (UserException e) {
            e.getMessage();
        }
    }

    /**
     * Method print list bids
     */
    public void viewAllBidsByGood(){
        try {
            List<Good> list = adminController.listAllGoodsByCategory(selectCategory());
            printList(adminController.listAllBidsByGood(selectGood(list)));
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method change data users
     */
    public void changeAdminData(){
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        adminController.changeAdminData(name, password,admin);
    }

    private Category selectCategory() throws UserException {
        System.out.println();
        System.out.println("Выберите категорию:");
        List<Category> list = adminController.getListCategory();
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
