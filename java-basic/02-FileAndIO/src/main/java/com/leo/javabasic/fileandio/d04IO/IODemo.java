package com.leo.javabasic.fileandio.d04IO;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Leo on 2019/12/19.
 * Description :
 */

/*
    输入流：磁盘重的数据读取到内存中
    输出流：内存中的数据写入到磁盘中
    InputStream OutputStream  字节IO流
    Reader  Writer            字符流

    OutputStream: 所有字节输出流的父类，abstract类
     * @see     java.io.BufferedOutputStream
     * @see     java.io.ByteArrayOutputStream
     * @see     java.io.DataOutputStream
     * @see     java.io.FilterOutputStream
     * @see     java.io.InputStream
     * @see     java.io.OutputStream#write(int)

 */
public class IODemo {

    public static void main(String[] args) throws IOException, InterruptedException {

//        outputStream();

//        inputStream2();

//        reader();

        writer();
    }


    /*
        flush() 刷新缓冲区，写到磁盘，流对象可以继续使用
        close() 刷新缓冲区，写到磁盘，释放流对象
     */
    private static void writer() throws IOException, InterruptedException {
        FileWriter fw = new FileWriter("a.txt");

        int i = 0;
        while (i < 100) {
            System.out.println(i);
            fw.write("上海");
            i++;
        }

        fw.close();

    }


    private static void reader() throws IOException {

        FileReader fr = new FileReader("a.txt");
//        int len = fr.read();
//        System.out.println((char) len);

//        int len = 0;
//        while ((len = fr.read()) != -1) {
//            System.out.println((char) len);
//        }

        char[] chars = new char[1024];
        int len1 = 0;
        while ((len1 = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len1));
        }

        fr.close();

    }



    private static void inputStream2() throws IOException {
        FileInputStream fis = new FileInputStream("/Users/leo/Desktop/tiger.jpg");
        FileOutputStream fos = new FileOutputStream("tiger_copy.jpg");

        byte[] bytes = new byte[1024]; // 一次读取1024个字节
        int len = 0; // 每次读取的有效字节个数
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(Arrays.toString(bytes));
            fos.write(bytes, 0, len);
        }

        fos.close();
        fis.close();

    }

    //一次读取一个字节
    private static void inputStream1() throws IOException {

        FileInputStream fis = new FileInputStream("/Users/leo/Desktop/tiger.jpg");
//        int len = fis.read();
//        System.out.println(len);
        int len = 0;
        while (len != -1) {
            len = fis.read();
            System.out.println(len);
        }

        fis.close();

    }


    private static void outputStream() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/leo/Desktop/a.txt");
            System.out.println(fileOutputStream);
//            fileOutputStream.write("abc".getBytes());
//            fileOutputStream.write("def".getBytes());
            fileOutputStream.write(97);

            fileOutputStream.close();


            // FileOutputStream(String name, boolean append)  append 追加写
            FileOutputStream fileOutputStream1 = new FileOutputStream("/Users/leo/Desktop/b.txt", true);
            System.out.println(Arrays.toString("Hello World".getBytes()));
            fileOutputStream1.write("Hello World".getBytes());
            // 换行 Windows: \r\n  linux: \n  mac: \r
            fileOutputStream1.write("\r".getBytes());
            fileOutputStream1.write("Hello World".getBytes());

            fileOutputStream1.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


}
