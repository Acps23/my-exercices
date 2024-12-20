package io.codeforall.fanstatics;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable {

    private static final Logger logger = Logger.getLogger(Client.class.getName());
    private final Socket clientSocket;
    private final WebServer server;

    public Client(Socket clientSocket, WebServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }  // Constructor accepting the client Socket and a reference to the WebServer

    @Override
    public void run() {
        server.dispatch(clientSocket);   // Call the dispatch method in WebServer to handle the request
    }
}

