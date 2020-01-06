package com.leo.javabasic.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Leo on 2019/12/20.
 * Description :
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream os = socket.getOutputStream();
        os.write("你好服务器".getBytes());
        // 防阻塞
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        System.out.println("---end---");

        socket.close();

    }


}
