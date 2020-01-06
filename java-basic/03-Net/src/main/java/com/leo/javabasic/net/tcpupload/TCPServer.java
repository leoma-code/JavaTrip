package com.leo.javabasic.net.tcpupload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();

                        File file = new File("upload");
                        if (!file.exists()) {
                            file.mkdirs();
                        }


                        String fileName = "leo_" + System.currentTimeMillis() + "_" + new Random().nextInt(999999) + ".jpeg";
                        FileOutputStream fos = new FileOutputStream(file + "/" + fileName);

                        System.out.println(" --- come here1 ----");
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }

                        System.out.println(" --- come here2 ----");

                        OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes());

                        socket.close();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

//        serverSocket.close();

    }
}
