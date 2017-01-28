package com.egar.auction.client;

import com.egar.auction.client.console.adminConsole.AdminItemConsole;
import com.egar.auction.client.console.guestConsole.GuestItemConsole;
import com.egar.auction.client.console.userConsole.UserItemConsole;
import com.egar.auction.model.Admin;
import com.egar.auction.model.AuthorizedUser;
import com.egar.auction.model.Guest;
import com.egar.auction.model.requests.LogIn;

import java.io.*;
import java.net.Socket;

/**
 * Auction clients.
 *
 * @author Eldar Ziatdinov
 * @version 1.0
 */
public class Client {

    private String host;
    private int port;

    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private BufferedReader br;
    private AuthorizedUser user;
    private Admin admin;
    private Guest guest;

    /**
     * Create Client with a certain host and port.
     * Client connection to server.
     */
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connectToServer() throws IOException {
        try {
            clientSocket = new Socket(host, port);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * @see Client#Client(String, int)
     */
    public Client(int port) throws IOException {
        this("localhost", port);
    }

    /**
     * Log in through AuthorizedUser
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void logIn() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        out.writeObject(new LogIn(name, password,false));
        try {
            Object object = in.readObject();
            if(object instanceof Throwable)
                System.out.println(((Throwable) object).getMessage());
            else {
                user = (AuthorizedUser) object;
                new UserItemConsole(user, br, out, in).show();
                disconnect();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Log in through Admin
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void logInToAdmin() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите пароль:");
        String password = br.readLine();
        out.writeObject(new LogIn(name, password,true));
        try {
            Object object = in.readObject();
            if(object instanceof Throwable)
                System.out.println(((Throwable) object).getMessage());
            else {
                admin = (Admin) object;
                new AdminItemConsole(admin, br, out, in).show();
                disconnect();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Log in through Guest
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void logInToGuest() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя:");
        String name = br.readLine();
        out.writeObject(new LogIn(name, null,false));
        try {
            Object object = in.readObject();
            if(object instanceof Throwable)
                System.out.println(((Throwable) object).getMessage());
            else {
                guest = (Guest) object;
                new GuestItemConsole(br, guest, out, in).show();
                disconnect();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Disconnect client with sever
     *
     * @throws IOException
     */
    public void disconnect() throws IOException {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client(2222);
            client.connectToServer();
            client.logIn();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
