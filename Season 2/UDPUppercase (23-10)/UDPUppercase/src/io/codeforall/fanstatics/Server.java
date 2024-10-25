package io.codeforall.fanstatics;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private int localPort = 6087;
    private byte[] recvBuffer = new byte[1024];

    public Server() {
        while (true) {
            try {
                DatagramSocket socket = new DatagramSocket(localPort);

                DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

                socket.receive(receivePacket);
                byte[] receiveData = receivePacket.getData();
                String message = new String(receiveData, 0, receivePacket.getLength(), "UTF-8");
                //message.toUpperCase();
                InetAddress netCatAddress = receivePacket.getAddress();
                int netCatPort = receivePacket.getPort();
                byte[] messageBytes = message.toUpperCase().getBytes("UTF-8");
                DatagramPacket messagepacket = new DatagramPacket(messageBytes, 0, messageBytes.length, netCatAddress, netCatPort);
                socket.send(messagepacket);
            } catch (
                    SocketException e) {
                System.out.println(e.getMessage());
            } catch (
                    IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}