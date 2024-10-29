package io.codeforall.fanstatics;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private static List<ServerWorker> clientList = Collections.synchronizedList(new LinkedList<>());

    public static void main(String[] args) {
        try {
            int portNumber = 9800;
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                ServerWorker worker = new ServerWorker(clientSocket, clientList);
                clientList.add(worker); // Add the new client to the list
                new Thread(worker).start(); // Start a new thread for each client
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}