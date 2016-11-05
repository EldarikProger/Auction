package com.egar.auction.view.console.action_console;

import com.egar.auction.controllers.user_controllers.GuestController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.util.List;
import java.util.Scanner;

public class GuestActionConsole {

    private GuestController guestController;
    private Scanner scanner;

    public GuestActionConsole(GuestController guestController, Scanner scanner) {
        this.scanner = scanner;
        this.guestController = guestController;
    }

    public void viewAllGoodsByCategory(){
        try {
            printList(guestController.listAllGoodsByCategory(selectCategory()));
        } catch (UserException e) {
            e.getMessage();
        }
    }

    public void viewAllBidsByGood() {
        try {
            List<Good> list = guestController.listAllGoodsByCategory(selectCategory());
            printList(guestController.listAllBidsByGood(selectGood(list)));
        } catch (UserException e) {
            System.out.println(e.getMessage());
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
        List<Category> list = guestController.getListCategory();
        int i = 1;
        for (Category c : list) {
            System.out.println((i++) + ") " + c.getName());
        }
        int j = scanner.nextInt();
        if (j <= 0 || j > list.size())
            throw new UserException("Вы выбрали не существующую категорию!");
        return list.get(j-1);
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
