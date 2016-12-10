package com.egar.auction.view.console.itemConsole;

import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.exceptions.UserException;
import com.egar.auction.exceptions.UserNotFoundException;
import com.egar.auction.model.Admin;
import com.egar.auction.view.console.actionConsole.AdminActionConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * AdminItemConsole is the admin presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class AdminItemConsole {

    private BufferedReader br;
    private AdminController adminController;
    private AdminActionConsole actionConsole;
    private Admin myAdmin;

    /**
     * Create item and action console for admin
     *
     * @param adminController manage controller for admin
     * @param br         to input data
     */
    public AdminItemConsole(AdminController adminController, BufferedReader br) {
        this.br = br;
        this.adminController = adminController;
        actionConsole = new AdminActionConsole(adminController, br, null);
    }

    /**
     * Method show view admin item console
     */
    public void show() {
        try {
            connect();
            actionConsole.setMyAdmin(myAdmin);
            System.out.println();
            System.out.println("Администратор " + myAdmin.getName() + ":");
            boolean nextRun = true;
            while (nextRun) {
                switch (menuAdmin()) {
                    case 1:
                        actionConsole.viewListUsers();
                        break;
                    case 2:
                        actionConsole.viewListAdmin();
                        break;
                    case 3:
                        actionConsole.viewStatisticByUsers();
                        break;
                    case 4:
                        actionConsole.viewAllGoodsByCategory();
                        break;
                    case 5:
                        actionConsole.viewAllBidsByGood();
                        break;
                    case 6:
                        actionConsole.changeAdminData();
                        break;
                    case 7:
                        myAdmin = null;
                        nextRun = false;
                        break;
                    default:
                        System.out.println("Вы выбрали несуществующий вариант!");
                }
            }
        } catch (UserNotFoundException | UserException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void connect() throws UserNotFoundException, UserException, IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        myAdmin = adminController.connectToAdmin(name, password);
    }

    private int menuAdmin() throws IOException {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список пользователей");
        System.out.println("2) Посмотреть список всех администраторов");
        System.out.println("3) Посмотреть статистику по пользователям");
        System.out.println("4) Посмотреть список товаров по категории");
        System.out.println("5) Посмотреть список всех ставок по товару");
        System.out.println("6) Ввести свои новые данные");
        System.out.println("7) Выход");
        int a;
        while (true) {
            try {
                a = Integer.parseInt(br.readLine());
                break;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Вы ввели не число, введите число заново");
            }
        }
        return a;
    }

}
