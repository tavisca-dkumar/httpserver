package com.tavisca.workshops.dokumar;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpResponseHandler {

    public void sendResponse(String fileName, BufferedOutputStream out) throws IOException {
        FileHandle fileHandler = new FileHandle();
        byte[] fileData= new byte[0];
        try {
            fileData = fileHandler.fileHandling(fileName);
            ResourseFileExtention resourseFileExtention=new ResourseFileExtention();
            int size =fileData.length;
            String contentType=resourseFileExtention.resourseFileContentTypeReturner(fileName);
            String responseContentTypeString="Content-type: "+contentType+"\n";
            out.write("HTTP/1.1 200 OK\n".getBytes());
            out.write(responseContentTypeString.getBytes());
            String contentLength = "Content-Length: " + size + "\n";
            out.write(contentLength.getBytes());
            out.write("\n".getBytes());
            out.write(fileData);
            out.flush();
        } catch (FileNotFoundException e) {
            sendResponse("fileNotFoundCode.html",out);
        }

    }
}
