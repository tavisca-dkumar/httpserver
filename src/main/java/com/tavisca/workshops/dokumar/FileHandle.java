package com.tavisca.workshops.dokumar;

import java.io.*;

public class FileHandle {
    private MyLogger myLogger=new MyLogger();
    public byte[] fileHandling(String fileName) throws FileNotFoundException
   {
        FileInputStream file = new FileInputStream(fileName);
        myLogger.logMessage(fileName+" file is opened");
        int size = 0;
        byte[] fileData=null;
        try {

            size = file.available();
            fileData= new byte[size];
            file.read(fileData);
            file.close();
            myLogger.logMessage(fileName+" file is closed");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  fileData;
    }
}
