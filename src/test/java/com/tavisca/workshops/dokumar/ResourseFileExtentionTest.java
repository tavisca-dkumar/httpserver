package com.tavisca.workshops.dokumar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourseFileExtentionTest {

    @Test
    public void isResourseFileExtentionMapsResponseContentType(){
        ResourseFileExtention resourseFileExtention=new ResourseFileExtention();
        assertEquals("text/plain",resourseFileExtention.resourseFileContentTypeReturner("siva.txt"));
        assertEquals("text/html",resourseFileExtention.resourseFileContentTypeReturner("siva.html"));
        assertEquals("images/jpeg",resourseFileExtention.resourseFileContentTypeReturner("siva.jpg"));
        assertEquals("images/png",resourseFileExtention.resourseFileContentTypeReturner("siva.png"));
    }
}
