package io.codeforall.fanstatics;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MAIN {
    public static void main(String[] args) {
        String urlStr = "https://www.google.com";
        BufferedInputStream reader = null;
        try {
            URL url = new URL(urlStr);
            InputStream inputStream = url.openStream();
            reader = new BufferedInputStream(inputStream);

            int c;
            while((c = reader.read())!=-1){
                System.out.println((char) c);
            }
            } catch (MalformedURLException e){
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            try {
                if (reader != null) {
                    reader.close();

        } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
