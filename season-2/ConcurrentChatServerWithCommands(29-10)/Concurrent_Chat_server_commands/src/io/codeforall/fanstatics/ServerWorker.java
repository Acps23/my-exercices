package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.List;

public class ServerWorker implements Runnable {
    private Socket clientSocket;
    private List<ServerWorker> clientList;
    private PrintWriter out;
    private String clientName;

    public ServerWorker(Socket socket, List<ServerWorker> clientList) {
        this.clientSocket = socket;
        this.clientList = clientList;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Ask for client name
            out.println("Enter your name: ");
            clientName = in.readLine();
            System.out.println(clientName + " has joined the chat!");
            broadcast(clientName + " has joined the chat!");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("List")) {
                    sendClientList();
                } else if (inputLine.toLowerCase().startsWith("whisper ")) {
                    whisper(inputLine);
                } else if (inputLine.equalsIgnoreCase("Quit")) {
                    quit();
                } else if (inputLine.toLowerCase().startsWith("changename ")) {
                    changeName(inputLine);
                }else if (inputLine.equalsIgnoreCase("Help")){
                    sendHelp();
                } else {
                    System.out.println(clientName + ": " + inputLine);
                    broadcast(clientName + ": " + inputLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    private void changeName(String inputLine) {
            String[] parts = inputLine.split(" ", 2);
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                out.println("Usage: change name <newName>");
                return;
            }

            String newName = parts[1].trim();

            // Check for name uniqueness
            for (ServerWorker worker : clientList) {
                if (worker.clientName.equalsIgnoreCase(newName)) {
                    out.println("Name \"" + newName + "\" is already taken. Please choose another.");
                    return;
                }
            }

            // Notify others of the name change
            broadcast(clientName + " has changed their name to " + newName);
            clientName = newName; // Update the client's name
            out.println("Your name has been changed to: " + clientName);
        }

    private void quit() {
        try {
            clientSocket.close();
            broadcast(clientName + " has left the chat.");
            clientList.remove(this);
            System.out.println(clientName + " has disconnected.");
        } catch (IOException e) {
            System.out.println("Error closing the socket: " + e.getMessage());
        }
    }

    private void whisper(String input) {
        // Split the input into parts
        String[] parts = input.split(" ", 3); // Split into 3 parts: "whisper", targetName, message
        if (parts.length < 3) {
            out.println("Usage: whisper <targetName> <message>");
            return;
        }

        String targetName = parts[1];
        String message = parts[2];

        // Find the target client
        for (ServerWorker worker : clientList) {
            if (worker.clientName.equalsIgnoreCase(targetName)) {
                worker.out.println("(Whisper from " + clientName + "): " + message);
                out.println("(Whisper to " + targetName + "): " + message);
                return;
            }
        }
        out.println("User " + targetName + " not found.");
    }


    private void broadcast(String message) {
        for (ServerWorker worker : clientList) {
            if (worker != this) { //Do not send message to the sender
                worker.out.println(message);
            }
        }
    }

    private void sendHelp() {
        String helpMessage = "Available commands:\n" +
                "1. changename <newName> - Change your username.\n" +
                "2. quit - Exit the chat.\n" +
                "3. whisper <targetName> <message> - Send a private message to a specific user.\n" +
                "4. List - Show all connected users.";
        out.println(helpMessage);
    }

    private void sendClientList() {
        StringBuilder clientNames = new StringBuilder("Connected clients:\n");
        for (ServerWorker worker : clientList) {
            clientNames.append(worker.clientName).append("\n");
        }
        out.println(clientNames);
    }
}

//help
//changecolour
