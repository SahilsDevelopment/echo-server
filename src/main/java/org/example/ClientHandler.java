package org.example;

import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler{

    public final int port;

    public ClientHandler(int port) {
        this.port = port;
    }

    public void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server Started on port "+port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("New Client Connected "+clientSocket.getInetAddress().getHostName());
                Thread thread = new Thread(new ConnectionHandler(clientSocket, port));
                thread.start();
            }

        } catch (Exception e) {
            System.out.printf("Exception Occurred %s", e);;
        }
    }
}
