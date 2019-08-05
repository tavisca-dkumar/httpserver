package com.tavisca.workshops.dokumar;

import org.junit.Test;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RequestHandlerTest {

    @Test
    public void isExtractFileNameAndMethodName(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("test.txt");
            String expectedFirstLineOfRequestData="GET /siva.txt HTTP/1.1";
            fileOutputStream.write(expectedFirstLineOfRequestData.getBytes());
            FileInputStream fileInputStream=new FileInputStream("test.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            HttpRequestHandler httpRequestHandler=new HttpRequestHandler();
            List<String> strings=httpRequestHandler.parseRequest(bufferedInputStream);
            String fileName=strings.get(1);
            String methodName=strings.get(0);
            assertEquals("siva.txt",fileName);
            assertEquals("GET",methodName);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void isExtractEmptyFileName(){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("test.txt");
            String expectedFirstLineOfRequestData="GET / HTTP/1.1";
            fileOutputStream.write(expectedFirstLineOfRequestData.getBytes());
            FileInputStream fileInputStream=new FileInputStream("test.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            HttpRequestHandler httpRequestHandler=new HttpRequestHandler();
            List<String> strings=httpRequestHandler.parseRequest(bufferedInputStream);
            String fileName=strings.get(1);
            assertTrue(fileName.isEmpty());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
