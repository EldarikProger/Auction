package com.egar.auction.view.console.action_console;


import com.egar.auction.controllers.user_controllers.AdminController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.List;
import java.util.Scanner;

public class AdminActionConsole {

    private Scanner scanner;
    private AdminController adminController;

    public AdminActionConsole(AdminController adminController, Scanner scanner) {
        this.adminController = adminController;
        this.scanner = scanner;
    }

    public void viewListUsers(){
        printList(adminController.listAllUsers());
    }

    public void viewListAdmin(){
        printList(adminController.listAllAdmins());
    }

    public void viewStatisticByUsers(){
        printList(adminController.getUserStatistics());
    }

    public void viewAllGoodsByCategory(){
        try {
            printList(adminController.listAllGoodsByCategory(selectCategory()));

        } catch (UserException e) {
            e.getMessage();
        }
    }

    public void viewAllBidsByGood(){
        try {
            List<Good> list = adminController.listAllGoodsByCategory(selectCategory());
            printList(adminController.listAllBidsByGood(selectGood(list)));
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeAdminData(){
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        adminController.changeAdminData(name, password);
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
