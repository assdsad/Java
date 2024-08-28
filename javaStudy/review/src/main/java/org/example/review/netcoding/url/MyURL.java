package org.example.review.netcoding.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://ss2.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=455163689,1459873792&fm=253&gp=0.jpg");

            URLConnection con = url.openConnection();

            InputStream is = con.getInputStream();

            File file = new File("G:/a.png");
            OutputStream os = new FileOutputStream(file);
            int b;
            while((b = is.read()) != -1) {
                os.write(b);
            }

            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            URL myURL = new URL("http://java.sun.com");
//            String protocal = myURL.getProtocol();//获得协议
//            String host = myURL.getHost();
//            String file = myURL.getFile();
//            int port = myURL.getPort();
//            String ref = myURL.getRef();
//
//            System.out.println(protocal + "," + host + "," + file + "," + port + "," + ref);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
}
