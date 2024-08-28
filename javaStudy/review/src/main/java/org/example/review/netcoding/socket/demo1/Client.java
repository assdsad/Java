package org.example.review.netcoding.socket.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            os.write("hello world".getBytes());
            os.flush();

            byte[] cache = new byte[1024];
            is.read(cache);
            System.out.println("服务端发来的消息为：" + new String(cache));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
