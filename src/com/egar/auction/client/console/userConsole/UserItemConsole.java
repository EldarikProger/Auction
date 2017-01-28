package com.egar.auction.client.console.userConsole;

import com.egar.auction.model.AuthorizedUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * User UserItemConsole is the user presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class UserItemConsole {

    private UserActionConsole actionConsole;
    private ItemConsoleUserPurchase userPurchase;
    private AuthorizedUser myUser;
    private BufferedReader br;

    /**
     * Create item console
     *
     * @param myUser
     * @param br
     */
    public UserItemConsole(AuthorizedUser myUser, BufferedReader br, ObjectOutputStream out, ObjectInputStream in) {
        this.myUser = myUser;
        this.br = br;
        this.actionConsole = new UserActionConsole(br, myUser,in ,out);
        this.userPurchase = new ItemConsoleUserPurchase(myUser,br,in,out);
    }

    /**
     * Method show view user item console
     */
    public void show() {
        System.out.println();
        System.out.println("Пользователь " + myUser.getName() + ":");
        boolean nextRun = true;
        while (nextRun) {
            switch (menuUser()) {
                case 1:
                    actionConsole.viewListUserGoods();
                    break;
                case 2:
                    actionConsole.viewListUserBids();
                    break;
                case 3:
                    actionConsole.viewAllGoodsByCategory();
                    break;
                case 4:
                    actionConsole.viewAllBidsByGood();
                    break;
                case 5:
                    actionConsole.addGood();
                    break;
                case 6:
                    actionConsole.makeBet();
                    break;
                case 7:
                    userPurchase.show();
                    break;
                case 8:
                    actionConsole.changeUserData();
                    break;
                case 9:
                    actionConsole.addUserCoordinate();
                    break;
                case 10:
                    actionConsole.exit();
                    nextRun = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }
    }


    private int menuUser() {
        System.out.println();
        System.out.println("Выберите одно из действий");
        System.out.println("1) Посмотреть список моих товаров");
        System.out.println("2) Посмотреть список моих ставок");
        System.out.println("3) Посмотреть список всех товаров по категории");
        System.out.println("4) Посмотреть список всех ставок по товару");
        System.out.println("5) Добавить товар");
        System.out.println("6) Сделать ставку");
        System.out.println("7) Мои покупки");
        System.out.println("8) Ввести свои новые данные");
        System.out.println("9) Ввести свои координаты");
        System.out.println("10) Выход");
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
