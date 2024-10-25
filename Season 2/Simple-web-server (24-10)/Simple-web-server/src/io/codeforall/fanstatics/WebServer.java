package io.codeforall.fanstatics;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) {

        int portNumber = 8888;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Waiting for client...");

        while (true) {
            try {


                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message = in.readLine();
                OutputStream outputStream = clientSocket.getOutputStream();

                switch (message) {
                    case "GET /index.html HTTP/1.1":
                        byte[] bytes = new byte[6000];
                        FileInputStream inputStream = new FileInputStream("rsc/index.html");
                        int bytesread = inputStream.read(bytes);
                        String httpresponde = " HTTP/1.0 200 Document Follows\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n " +
                                "Content-Length:" + bytesread + "\r\n" +
                                "\r\n";
                        out.println(httpresponde);
                        outputStream.write(bytes, 0, bytesread);

                        break;
                    case "GET /logo.png HTTP/1.1":
                        bytes = new byte[6000];
                        File fileimage = new File("rsc/logo.png");
                        inputStream = new FileInputStream(fileimage);

                        bytesread = inputStream.read(bytes);
                        String httprespondelogo = " HTTP/1.0 200 Document Follows\r\n" +
                                "Content-Type: image/png \r\n" +
                                "Content-Length:" + bytesread + " \r\n" +
                                "\r";
                        out.println(httprespondelogo);
                        System.out.println("size " + bytesread);
                        outputStream.write(bytes, 0, bytesread);
                        outputStream.flush();
                        break;
                    case "GET /404.html HTTP/1.1":
                        bytes = new byte[6000];
                        inputStream = new FileInputStream("rsc/404.html");
                        bytesread = inputStream.read(bytes);
                        String httprespondeerro = " HTTP/1.0 404 Not Found\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n " +
                                "Content-Length:" + bytesread + "\r\n" +
                                "\r\n";
                        out.println(httprespondeerro);
                        outputStream.write(bytes, 0, bytesread);
                        break;
                }


                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

/*
HTTP/1.0 200 Document Follows\r\n
        Content-Type: text/html; charset=UTF-8\r\n
        Content-Length: <file_byte_size> \r\n
        \r\n

        HTTP/1.0 200 Document Follows\r\n
        Content-Type: image/<image_file_extension> \r\n"
        Content-Length: <file_byte_size> \r\n
        \r\n

        HTTP/1.0 404 Not Found
        Content-Type: text/html; charset=UTF-8\r\n
        Content-Length: <file_byte_size> \r\n
        \r\n*/
