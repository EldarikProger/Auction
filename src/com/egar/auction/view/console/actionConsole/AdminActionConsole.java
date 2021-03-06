package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Admin;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * AdminActionConsole is the action admin
 *
 * @version 1.1
 * @author Eldar Ziatdinov
 */
public class AdminActionConsole {

    private BufferedReader br;
    private AdminController adminController;
    private Admin myAdmin;

    /**
     * Create AdminActionConsole for presentation it actions
     * @param admin user which sing in
     * @param adminController controller for manage
     * @param br to input data
     */
    public AdminActionConsole(AdminController adminController, BufferedReader br, Admin admin) {
        this.adminController = adminController;
        this.br = br;
        this.myAdmin = admin;
    }

    /**
     * Put user for manage
     * @param myAdmin
     */
    public void setMyAdmin(Admin myAdmin) {
        this.myAdmin = myAdmin;
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
    public void changeAdminData() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        adminController.changeAdminData(name, password, myAdmin);
    }

    private Category selectCategory() throws UserException {
        System.out.println();
        System.out.println("Выберите категорию:");
        List<Category> list = adminController.getListCategory();
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
