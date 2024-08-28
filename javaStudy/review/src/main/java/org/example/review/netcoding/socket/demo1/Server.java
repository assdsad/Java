package org.example.review.netcoding.socket.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("监听到一个客户端");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            byte[] cache = new byte[1024];
            is.read(cache);
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println("客户端发来的消息为：" + new String(cache) + "ip: " + ip);

            os.write("received".getBytes());
            os.flush();

            serverSocket.close();
            socket.close();
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
