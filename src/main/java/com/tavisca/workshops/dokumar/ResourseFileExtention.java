package com.tavisca.workshops.dokumar;

import java.util.HashMap;

public class ResourseFileExtention {
    public static HashMap<String,String> contentTypeMap = new HashMap<String, String>(){{
        put("txt","text/plain");
        put("html","text/html");
        put("jpg","images/jpeg");
        put("png","images/png");
    }};

    public String resourseFileContentTypeReturner(String filename){
        String splits[] = filename.split("\\.");
        return contentTypeMap.get(splits[1]);
    }

}
