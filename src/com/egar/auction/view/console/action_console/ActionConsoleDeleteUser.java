package com.egar.auction.view.console.action_console;


import com.egar.auction.controllers.DatabaseController;

import java.util.Scanner;

public class ActionConsoleDeleteUser {

    private Scanner scanner;
    private DatabaseController databaseController;

    public ActionConsoleDeleteUser(DatabaseController databaseController, Scanner scanner) {
        this.scanner = scanner;
        this.databaseController = databaseController;
    }

    public void showDeleteUser(){
        System.out.println();
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        databaseController.deleteAuthorizedUser(name, password);
        System.out.println("Пользователь удален!");
    }

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
