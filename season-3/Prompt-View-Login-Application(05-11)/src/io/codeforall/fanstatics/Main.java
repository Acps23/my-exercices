package io.codeforall.fanstatics;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {
    public static void main(String[] args) {

        String correctUsername = "Rui";
        String correctPassword = "senha123";

        Prompt prompt = new Prompt(System.in, System.out);

        StringInputScanner message = new StringInputScanner();

        message.setMessage("Welcome to your first Prompt-View Experience!");
        message.setMessage("Insert your login credentials below:");

        StringInputScanner username = new StringInputScanner();
        username.setMessage("Username: ");
        String user = prompt.getUserInput(username);

        StringInputScanner password = new StringInputScanner();
        password.setMessage("Password: ");
        String userpassword = prompt.getUserInput(password);



        if (user.equals(correctUsername) && userpassword.equals(correctPassword)) {
            System.out.println("\nLogin Successful!");
            System.out.println("Welcome home, " + user + "!");
        } else {
            System.out.println("\nLogin Failed. Please check your credentials and try again.");
        }
    }
}
