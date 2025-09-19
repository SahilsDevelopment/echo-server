package org.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class TCPApplicationMain {

    @Parameter(names = {"-p", "--port"}, description = "Default port for the Server to Run On")
    private int port = 8080;

    public static void main(String[] args) {
        TCPApplicationMain tcpApplicationMain = new TCPApplicationMain();
        JCommander commander = JCommander.newBuilder()
                .addObject(tcpApplicationMain)
                .build();
        commander.parse(args);

        tcpApplicationMain.start();
    }

    public void start(){
        ClientHandler clientHandler = new ClientHandler(port);
        clientHandler.startServer();
    }
}