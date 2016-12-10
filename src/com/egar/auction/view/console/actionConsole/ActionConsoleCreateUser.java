package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.DatabaseController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ActionConsoleCreateUser is the presentation for create users
 *
 * @author Eldar Ziatdinov
 * @version 1.1
 */
public class ActionConsoleCreateUser {

    private BufferedReader br;
    private DatabaseController databaseController;

    /**
     * Create action console
     *
     * @param databaseController controller for create users
     * @param br            to input data
     */
    public ActionConsoleCreateUser(DatabaseController databaseController, BufferedReader br) {
        this.br = br;
        this.databaseController = databaseController;
    }

    /**
     * Show console for create AuthorizedUser
     */
    public void showCreateUser() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        databaseController.createAuthorizedUser(name, password);
        System.out.println("Пользователь создан!");
    }

    /**
     * Show console for create Admin
     */
    public void showCreateAdmin() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        databaseController.createAdmin(name, password);
        System.out.println("Администратор создан!");
    }
}
