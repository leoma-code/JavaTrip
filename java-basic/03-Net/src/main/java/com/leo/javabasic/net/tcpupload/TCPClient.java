package com.leo.javabasic.net.tcpupload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */
public class TCPClient {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        FileInputStream fis = new FileInputStream("/Users/leo/Desktop/sky.jpeg");

                        Socket socket = new Socket("127.0.0.1", 8888);
                        OutputStream os = socket.getOutputStream();

                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }

                        // 防止阻塞  添加结束符 否则服务器段无法读取到-1结束符
                        socket.shutdownOutput();

                        InputStream is = socket.getInputStream();
                        while ((len = is.read(bytes)) != -1) {
                            System.out.println(new String(bytes, 0, len));
                        }

                        fis.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

    }

}
