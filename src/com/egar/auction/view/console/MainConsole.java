package com.egar.auction.view.console;

import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.userControllers.AdminController;
import com.egar.auction.controllers.userControllers.AuthorizedUserController;
import com.egar.auction.controllers.userControllers.GuestController;
import com.egar.auction.view.console.actionConsole.ActionConsoleCreateUser;
import com.egar.auction.view.console.actionConsole.ActionConsoleDeleteUser;
import com.egar.auction.view.console.itemConsole.AdminItemConsole;
import com.egar.auction.view.console.itemConsole.GuestItemConsole;
import com.egar.auction.view.console.itemConsole.UserItemConsole;

import java.util.Scanner;

/**
 * MainConsole is the common user presentation
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class MainConsole {

    private Scanner scanner;
    private ActionConsoleCreateUser consoleCreateUser;
    private ActionConsoleDeleteUser consoleDeleteUser;
    private UserItemConsole userItemConsole;
    private AdminItemConsole adminItemConsole;
    private GuestItemConsole guestItemConsole;

    /**
     * Create and show ConsoleView
     *
     * @param databaseController Controller
     */
    public MainConsole(DatabaseController databaseController) {
        scanner = new Scanner(System.in);
        consoleCreateUser = new ActionConsoleCreateUser(databaseController, scanner);
        consoleDeleteUser = new ActionConsoleDeleteUser(databaseController, scanner);
    }

    /**
     * Method show view common item console
     */
    public void show() {
        boolean runFlag = true;
        while (runFlag) {
            System.out.println();
            switch (mainMenu()) {

                case 1:
                    consoleCreateUser.showCreateUser();
                    break;
                case 2:
                    consoleCreateUser.showCreateAdmin();
                    break;
                case 3:
                    userItemConsole = new UserItemConsole(scanner);
                    userItemConsole.show();
                    userItemConsole = null;
                    break;
                case 4:
                    guestItemConsole = new GuestItemConsole(scanner);
                    guestItemConsole.show();
                    guestItemConsole = null;
                    break;
                case 5:
                    adminItemConsole = new AdminItemConsole(scanner);
                    adminItemConsole.show();
                    adminItemConsole = null;
                    break;
                case 6:
                    consoleDeleteUser.showDeleteUser();
                    break;
                case 7:
                    consoleDeleteUser.showDeleteAdmin();
                    break;
                case 8:
                    runFlag = false;
                    break;
                default:
                    System.out.println("Вы выбрали несуществующий вариант!");
            }
        }

    }

    private int mainMenu() {
        System.out.println("Выберите одно из действий");
        System.out.println("1) Создать пользователя");
        System.out.println("2) Создать администратора");
        System.out.println("3) Войти под пользователем");
        System.out.println("4) Войти гостем");
        System.out.println("5) Войти администратором");
        System.out.println("6) Удалить пользователя");
        System.out.println("7) Удалить администратора");
        System.out.println("8) Выход");
        return scanner.nextInt();
    }
}
