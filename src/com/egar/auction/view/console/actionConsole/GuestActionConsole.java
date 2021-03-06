package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * GuestActionConsole is the action guest
 *
 * @version 1.1
 * @author Eldar Ziatdinov
 */
public class GuestActionConsole {

    private GuestController guestController;
    private BufferedReader br;

    /**
     * Create GuestActionConsole for presentation it actions
     * @param guestController controller for manage
     * @param br to input data
     */
    public GuestActionConsole(GuestController guestController, BufferedReader br) {
        this.br = br;
        this.guestController = guestController;
    }

    /**
     * Method print list goods
     */
    public void viewAllGoodsByCategory(){
        try {
            printList(guestController.listAllGoodsByCategory(selectCategory()));
        } catch (UserException e) {
            e.getMessage();
        }
    }

    /**
     * Method print list bids
     */
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
        List<Category> list = guestController.getListCategory();
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
