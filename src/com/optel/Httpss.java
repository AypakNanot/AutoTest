package com.optel;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Httpss {

    public static void main(String[] args) throws IOException {
        URLConnection req = new URL("url").openConnection();
        req.setDoOutput(true);
        req.setRequestProperty("Content-Type", "application/json");
        String data = "";
        req.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
    }
}
