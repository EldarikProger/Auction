package com.egar.auction.client.console.adminConsole;


import com.egar.auction.model.Admin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminItemConsole {

    private AdminActionConsole actionConsole;
    private Admin myAdmin;
    private BufferedReader br;

    /**
     * Create item console
     *
     * @param myAdmin
     * @param br
     */
    public AdminItemConsole(Admin myAdmin, BufferedReader br, ObjectOutputStream out, ObjectInputStream in) {
        this.myAdmin = myAdmin;
        this.br = br;
        this.actionConsole = new AdminActionConsole(br, myAdmin,in ,out);
    }

    /**
     * Method show view user item console
     */
    public void show() {
        System.out.println();
        System.out.println("Администратор " + myAdmin.getName() + ":");
        boolean nextRun = true;
        while (nextRun) {
            switch (menuAdmin()) {
                case 1:
                    actionConsole.viewListUsers();
                    break;
                case 2:
                    actionConsole.viewStatisticByUsers();
                    break;
                case 3:
                    actionConsole.viewAllGoodsByCategory();
                    break;
                case 4:
                    actionConsole.viewAllBidsByGood();
                    break;
                case 5:
                    actionConsole.changeAdminData();
                    break;
                case 6:
                    actionConsole.exit();
                    nextRun = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }
    }


    private int menuAdmin(){
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список пользователей");
        System.out.println("2) Посмотреть статистику по пользователям");
        System.out.println("3) Посмотреть список товаров по категории");
        System.out.println("4) Посмотреть список всех ставок по товару");
        System.out.println("5) Ввести свои новые данные");
        System.out.println("6) Выход");
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
