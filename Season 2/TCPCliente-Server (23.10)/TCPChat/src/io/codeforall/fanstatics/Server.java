package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class Server {

    public static void main(String[] args) {


        try {
            int portNumber = 7888;
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                in.readLine();
                System.out.println(in.readLine());
                out.println(in.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

