package com.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://localhost:8080/frans/l.txt");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = httpURLConnection.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("l.txt");
        byte[] bytes = new byte[1024];
        int len;
        while((len = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        inputStream.close();
        httpURLConnection.disconnect();
    }
}
