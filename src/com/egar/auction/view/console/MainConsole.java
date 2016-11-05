package com.egar.auction.view.console;

import com.egar.auction.controllers.DatabaseController;
import com.egar.auction.controllers.user_controllers.AdminController;
import com.egar.auction.controllers.user_controllers.AuthorizedUserController;
import com.egar.auction.controllers.user_controllers.GuestController;
import com.egar.auction.view.console.action_console.ActionConsoleCreateUser;
import com.egar.auction.view.console.action_console.ActionConsoleDeleteUser;
import com.egar.auction.view.console.item_console.AdminItemConsole;
import com.egar.auction.view.console.item_console.GuestItemConsole;
import com.egar.auction.view.console.item_console.UserItemConsole;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;


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
     * @param adminController          UserController
     * @param authorizedUserController UserController
     * @param databaseController       Controller
     * @param guestController          UserController
     */
    public MainConsole(AdminController adminController, AuthorizedUserController authorizedUserController, DatabaseController databaseController, GuestController guestController) {
        scanner = new Scanner(System.in);
        adminItemConsole = new AdminItemConsole(adminController, scanner);
        userItemConsole = new UserItemConsole(authorizedUserController, scanner);
        consoleCreateUser = new ActionConsoleCreateUser(databaseController, scanner);
        consoleDeleteUser = new ActionConsoleDeleteUser(databaseController, scanner);
        guestItemConsole = new GuestItemConsole(guestController, scanner);
    }

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
                    userItemConsole.show();
                    break;
                case 4:
                    guestItemConsole.show();
                    break;
                case 5:
                    adminItemConsole.show();
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
