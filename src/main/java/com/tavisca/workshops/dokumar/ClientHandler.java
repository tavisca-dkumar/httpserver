package com.tavisca.workshops.dokumar;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements  Runnable{
    private Socket client;
    private BufferedInputStream in;
    private BufferedOutputStream out;
    private  HttpResponseHandler httpResponser;
    public ClientHandler(Socket ClientSocket) throws IOException {
        this.client=ClientSocket;
        this.in=new BufferedInputStream(client.getInputStream());
        this.out=new BufferedOutputStream(client.getOutputStream());
    }
    @Override
    public void run() {
        try {
            HttpRequestHandler request=new HttpRequestHandler();
            List<String> actualStrings=request.parseRequest(in);
            String methodName=actualStrings.get(0);
            String fileName=actualStrings.get(1);
            if(fileName.isEmpty())
                fileName="Home.html";
            if(methodName.equals("GET")) {
                httpResponser=new HttpResponseHandler();
                httpResponser.sendResponse(fileName,out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();in.close();out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
