package com.leo.javabasic.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {

            System.out.println(new String(bytes, 0, len));
        }

        outputStream.write("收到谢谢".getBytes());

        socket.close();
        serverSocket.close();
    }
}
