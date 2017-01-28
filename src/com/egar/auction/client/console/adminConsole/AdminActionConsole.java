package com.egar.auction.client.console.adminConsole;

import com.egar.auction.exceptions.UserException;
import com.egar.auction.model.Admin;
import com.egar.auction.model.Category;
import com.egar.auction.model.Good;
import com.egar.auction.model.requests.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * User ActionConsole is the action user
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class AdminActionConsole {

    private BufferedReader br;
    private Admin myAdmin;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    /**
     * Create UserActionConsole for presentation it actions
     *
     * @param in  read data from server
     * @param out send request to server
     * @param br  to input data
     */
    public AdminActionConsole(BufferedReader br, Admin user,
                             ObjectInputStream in, ObjectOutputStream out) {
        this.br = br;
        this.myAdmin = user;
        this.out = out;
        this.in = in;
    }

    /**
     * Method print list users
     */
    public void viewListUsers(){
        try{
            out.writeObject(new ViewAllUsers());
            List list = (List) in.readObject();
            printList(list);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print users statistics
     */
    public void viewStatisticByUsers(){
        try{
            out.writeObject(new GetUserStatistics());
            List list = (List) in.readObject();
            printList(list);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method print list goods
     */
    public void viewAllGoodsByCategory(){
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
    public void viewAllBidsByGood(){
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
     * Method change data users
     */
    public void changeAdminData() {
        try {
            System.out.println();
            System.out.println("Введите имя:");
            String name = br.readLine();
            System.out.println("Введите пароль:");
            String password = br.readLine();
            out.writeObject(new ChangeAdminData(name, password, myAdmin));
            myAdmin = (Admin) in.readObject();
            System.out.println("Данные изменены!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
