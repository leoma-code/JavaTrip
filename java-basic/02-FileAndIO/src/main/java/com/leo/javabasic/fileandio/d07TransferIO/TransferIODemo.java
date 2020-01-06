package com.leo.javabasic.fileandio.d07TransferIO;

import java.io.*;

/**
 * Created by Leo on 2019/12/20.
 * Description :
 */


// 编码转换流
public class TransferIODemo {

    public static void main(String[] args) {

        test1();
    }



    private static void test1() {

        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream("transfer.txt"), "GBK");
            osw.write("上海中心大厦");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // InputStreamReader读取
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream("transfer.txt"), "GBK");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = isr.read(chars)) != -1) {
                System.out.println("InputStreamReader读取 " + new String(chars, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // FileReader读取
        FileReader fr = null;
        try {
            fr = new FileReader("transfer.txt");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = fr.read(chars)) != -1) {
                System.out.print("FileReader读取 : " + new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
