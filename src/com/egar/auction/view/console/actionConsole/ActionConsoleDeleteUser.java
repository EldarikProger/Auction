package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.DatabaseController;

import java.util.Scanner;

/**
 * ActionConsoleDeleteUser is the presentation for delete users
 *
 * @version 1.1
 * @author Eldar Ziatdinov
 */
public class ActionConsoleDeleteUser {

    private Scanner scanner;
    private DatabaseController databaseController;

    /**
     * Create action console
     *
     * @param databaseController controller for delete users
     * @param scanner to input data
     */
    public ActionConsoleDeleteUser(DatabaseController databaseController, Scanner scanner) {
        this.scanner = scanner;
        this.databaseController = databaseController;
    }

    /**
     * Show console for delete AuthorizedUser
     */
    public void showDeleteUser(){
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        databaseController.deleteAuthorizedUser(name, password);
        System.out.println("Пользователь удален!");
    }

    /**
     * Show console for delete Admin
     */
    public void showDeleteAdmin(){
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        databaseController.deleteAdmin(name, password);
        System.out.println("Администратор удален!");
    }
}
