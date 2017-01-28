package com.egar.auction.server;

import com.egar.auction.exceptions.UserExitException;
import com.egar.auction.storage.AuctionDatabase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Auction server. Processing clients requests. Thread for client
 */
public class ThreadForClient extends Thread{

    private AuctionDatabase database;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    /**
     * Return socket which connect with client socket.
     * @return
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * Create new thread for each client
     * @param socket
     */
    ThreadForClient(Socket socket, AuctionDatabase database) {
        this.database = database;
        this.socket = socket;
        start();
    }

    /**
     * run thread
     */
    public void run() {
        processRequests();
    }

    /**
     * start thread(call run)
     */
    @Override
    public synchronized void start() {
        super.start();
    }

    /**
     * Interrupt this thread
     */
    @Override
    public void interrupt() {
        super.interrupt();
    }

    /**
     * Processing clients requests;
     */
    private void processRequests() { //для каждого клиента свой поток
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            ProcessingRequests processingRequests = new ProcessingRequests(in,out, database);

            while (true){ //пока клиент отправляет запросы
                // (если клиент отключится выкинет exception и выйдет с бесконечного цикла)
                try {
                    processingRequests.start();
                } catch (UserExitException | IOException e) {
                    System.out.println(e.getMessage());
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }  finally {
            try { //выполнить всегда!
                out.close();
                in.close();
                socket.close();
                this.interrupt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
