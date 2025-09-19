package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable{

    public final Socket socket;
    public final int port;

    public ConnectionHandler(Socket socket, int port) {
        this.socket = socket;
        this.port = port;
    }

    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            String message;
            while((message = bufferedReader.readLine()) != null){
                System.out.println("Received: "+message);
                writer.println("Echo: "+ message);
            }
        } catch (Exception e) {
            System.out.printf("Exception Occurred %s", e);;
        }
    }
}
