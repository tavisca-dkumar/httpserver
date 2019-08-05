package com.tavisca.workshops.dokumar;

import java.io.*;

public class FileHandler {

    public byte[] fileHandling(String fileName) throws FileNotFoundException
   {
        FileInputStream file = new FileInputStream(fileName);
        int size = 0;
        byte[] fileData=null;
        try {

            size = file.available();
            fileData= new byte[size];
            file.read(fileData);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  fileData;
    }
}
