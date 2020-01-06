package com.leo.javabasic.fileandio.d06BufferIO;

import java.io.*;

/**
 * Created by Leo on 2019/12/20.
 * Description :
 */

/*
    BufferedInputStream  缓冲字节输入流
    BufferedOutputStream 缓冲字节输出流

    BufferedReader  缓冲字符输入流
    BufferedWriter  缓冲字符输出流
 */

public class BufferIODemo {

    public static void main(String[] args) {

//        useFileInputStreamTestInterval();

        useBufferedInputStreamTestInterval();
    }


    // 使用BufferedInputStream 复制图片 耗时测试
    private static void useBufferedInputStreamTestInterval() {

        long start = System.currentTimeMillis();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("/Users/leo/Desktop/sky.jpeg"));
            bos = new BufferedOutputStream(new FileOutputStream("sky_copy.jpeg"));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("BufferedInputStream复制图片耗时 " + (end - start) + " 毫秒");
    }

    // 使用FileInputStream复制图片 耗时测试
    private static void useFileInputStreamTestInterval() {

        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("/Users/leo/Desktop/sky.jpeg");
            fos = new FileOutputStream("sky_copy.jpeg");

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("FileInputStream 复制图片耗时 " + (end - start) + " 毫秒");

    }





}
