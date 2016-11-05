package com.egar.auction.view.console.action_console;


import com.egar.auction.controllers.DatabaseController;

import java.util.Scanner;

public class ActionConsoleCreateUser {

    private Scanner scanner;
    private DatabaseController databaseController;


    public ActionConsoleCreateUser(DatabaseController databaseController, Scanner scanner) {
        this.scanner = scanner;
        this.databaseController = databaseController;
    }

    public void showCreateUser() {
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        databaseController.createAuthorizedUser(name, password);
        System.out.println("Пользователь создан!");
    }

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
