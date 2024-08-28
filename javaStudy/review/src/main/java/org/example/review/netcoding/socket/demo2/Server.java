package org.example.review.netcoding.socket.demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("启动服务端");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("监听到一个客户端");

                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
