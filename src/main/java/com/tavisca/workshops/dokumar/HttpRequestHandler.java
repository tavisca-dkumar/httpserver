package com.tavisca.workshops.dokumar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpRequestHandler {
    public List<String> parseRequest(BufferedInputStream in) throws IOException {
        byte buffer[] = new byte[256];
        in.read(buffer);
        String data=new String(buffer);
        List<String> strings = Arrays.asList(data.split("\\s+"));
        List<String> actualStrings=new ArrayList<>();
        actualStrings.add(strings.get(0));
        actualStrings.add(strings.get(1).replace('/',' ').trim());
        return actualStrings;
    }
}
