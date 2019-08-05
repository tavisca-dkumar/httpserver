package com.tavisca.workshops.dokumar;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCode {
    private ServerSocket serverSocket=null;
    boolean b=true;
    private Socket client;
    private MyLogger myLogger=new MyLogger();
    public void HttpData() throws IOException, InterruptedException {
     //   System.out.println("waiting for client....");
        myLogger.logMessage("waiting for class");
        serverSocket = new ServerSocket(80);
        while(b) {
            try {
                client = serverSocket.accept();
                //System.out.println("client accepted");
                myLogger.logMessage("client accepted");
                ClientHandler newClient= new ClientHandler(client);
                Thread clientThread = new Thread(newClient);
                clientThread.start();
                clientThread.join();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerCode serverCode=new ServerCode();
        serverCode.HttpData();
    }
}
