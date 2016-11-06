package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.DatabaseController;

import java.util.Scanner;

/**
 * ActionConsoleCreateUser is the presentation for create users
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class ActionConsoleCreateUser {

    private Scanner scanner;
    private DatabaseController databaseController;

    /**
     * Create action console
     *
     * @param databaseController controller for create users
     * @param scanner            to input data
     */
    public ActionConsoleCreateUser(DatabaseController databaseController, Scanner scanner) {
        this.scanner = scanner;
        this.databaseController = databaseController;
    }

    /**
     * Show console for create AuthorizedUser
     */
    public void showCreateUser() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        databaseController.createAuthorizedUser(name, password);
        System.out.println("Пользователь создан!");
    }

    /**
     * Show console for create Admin
     */
    public void showCreateAdmin() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        databaseController.createAdmin(name, password);
        System.out.println("Администратор создан!");
    }
}
