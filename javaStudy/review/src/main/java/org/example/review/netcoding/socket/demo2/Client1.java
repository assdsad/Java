package org.example.review.netcoding.socket.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            Scanner input = new Scanner(System.in);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            while(true) {
                String line = input.nextLine();
                os.write(line.getBytes());
                os.flush();

                byte[] cache = new byte[20];
                is.read(cache);
                System.out.println("服务端回复：" + new String(cache));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
