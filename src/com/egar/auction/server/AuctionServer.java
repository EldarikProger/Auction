package com.egar.auction.server;

import com.egar.auction.storage.AuctionDatabase;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Auction server. Processing clients requests.
 */
public class AuctionServer {

    private int port;
    private ServerSocket serverSocket;
    private AuctionDatabase database;

    /**
     * Create Server
     *
     * @param port
     */
    public AuctionServer(int port) {
        this.port = port;
    }

    /**
     * Start server
     */
    public void processing() {
        try {
            serverSocket = new ServerSocket(this.port);
            database = new AuctionDatabase(); //пусть временно БД будет в листах(всегда новая)
            Socket clientSocket;
            while (true) {
                try {
                    clientSocket = serverSocket.accept();
                    new ThreadForClient(clientSocket, database);
                } catch (IOException e){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! Sever is started!");
        AuctionServer server = new AuctionServer(2222);
        server.processing();
    }
}
