package org.example.review.netcoding.socket.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            while(true) {
                String ip = socket.getInetAddress().getHostAddress();
                byte[] cache = new byte[20];
                is.read(cache);
                if(new String(cache).equals("exit")) {//客户端说exit时退出
                    break;
                }
                System.out.println("ip为：" + ip + "的客户端说：" + new String(cache));

                os.write("received".getBytes());
                os.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
