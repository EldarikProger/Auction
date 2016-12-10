package com.egar.auction.view.console.actionConsole;

import com.egar.auction.controllers.DatabaseController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ActionConsoleDeleteUser is the presentation for delete users
 *
 * @version 1.1
 * @author Eldar Ziatdinov
 */
public class ActionConsoleDeleteUser {

    private BufferedReader br;
    private DatabaseController databaseController;

    /**
     * Create action console
     *
     * @param databaseController controller for delete users
     * @param br to input data
     */
    public ActionConsoleDeleteUser(DatabaseController databaseController, BufferedReader br) {
        this.br = br;
        this.databaseController = databaseController;
    }

    /**
     * Show console for delete AuthorizedUser
     */
    public void showDeleteUser() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        databaseController.deleteAuthorizedUser(name, password);
        System.out.println("Пользователь удален!");
    }

    /**
     * Show console for delete Admin
     */
    public void showDeleteAdmin() throws IOException {
        System.out.println();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        databaseController.deleteAdmin(name, password);
        System.out.println("Администратор удален!");
    }
}
