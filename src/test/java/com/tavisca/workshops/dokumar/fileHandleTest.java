package com.tavisca.workshops.dokumar;

import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class fileHandleTest {

    @Test
        public void isFileHandleReadFile() {
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream("siva.txt");
            String expectedData="this is siva";
            fileOutputStream.write(expectedData.getBytes());
            fileOutputStream.close();
            FileHandle fileHandle=new FileHandle();
            String actualData=new String(fileHandle.fileHandling("siva.txt"));
            assertEquals(expectedData,actualData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isFileHandleReadUnknownFile(){
        boolean unknownFile=false;
        FileHandle fileHandle = new FileHandle();
        try {
            fileHandle.fileHandling("xyz.txt");
        } catch (FileNotFoundException e) {
            unknownFile=true;
            e.printStackTrace();
        }
        assertTrue(unknownFile);
    }

}
