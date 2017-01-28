package com.egar.auction.client.console.guestConsole;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;
import com.egar.auction.model.requests.Exit;
import com.egar.auction.model.requests.ViewAllBids;
import com.egar.auction.model.requests.ViewAllGoods;
import com.egar.auction.model.requests.ViewListCategory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * GuestActionConsole is the action guest
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class GuestActionConsole {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private BufferedReader br;

    /**
     * Create GuestActionConsole for presentation it actions
     *
     * @param br    to input data
     * @param in
     * @param out
     */
    public GuestActionConsole(BufferedReader br, ObjectOutputStream out, ObjectInputStream in) {
        this.br = br;
        this.in = in;
        this.out = out;
    }

    /**
     * Method print list goods
     */
    public void viewAllGoodsByCategory() {
        try {
            out.writeObject(new ViewListCategory());
            List listCategory = (List) in.readObject();
            Category category = selectCategory(listCategory);
            out.writeObject(new ViewAllGoods(category));
            List listGoods = (List) in.readObject();
            printList(listGoods);
        } catch (UserException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print list bids
     */
    public void viewAllBidsByGood() {
        try {
            out.writeObject(new ViewListCategory());
            List listCategory = (List) in.readObject();
            Category category = selectCategory(listCategory);
            out.writeObject(new ViewAllGoods(category));
            List listGoods = (List) in.readObject();
            Good good = selectGood(listGoods);
            out.writeObject(new ViewAllBids(good));
            List listBids = (List) in.readObject();
            printList(listBids);
        } catch (UserException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * exit
     */
    public void exit(){
        try {
            out.writeObject(new Exit());
        } catch (IOException e) {
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

    private Category selectCategory(List<Category> list) throws UserException {
        System.out.println();
        System.out.println("Выберите категорию:");
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
