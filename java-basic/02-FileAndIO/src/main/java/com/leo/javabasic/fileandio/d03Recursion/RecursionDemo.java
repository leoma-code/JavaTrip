package com.leo.javabasic.fileandio.d03Recursion;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Leo on 2019/12/19.
 * Description :
 */


/*
recursion 递归
 */
public class RecursionDemo {

    public static void main(String[] args) throws InterruptedException {

//        a();

//        b(0);

//        int sum = sum(100);
//        System.out.println(sum);
//
//        System.out.println(factorial(10));

        File file = new File("/Users/leo/Desktop/test");
        printFile(file);


    }


    private static void printFile(File file) {
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (file.isDirectory()) { return true; }
                return pathname.getName().endsWith(".txt");
            }
        });


        if (files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printFile(f);
                } else {
                    System.out.println("文件路径：" + f.getAbsolutePath());
                }
            }
        }

    }



    // 递归（recursion）计算阶乘（factorial）
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    // 递归（recursion）求和
    private static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }



    private static void b(int i) {
        System.out.println("b 方法递归recursion ：" + i);

        if (i > 6000) {
            return;
        }

        i++;
        b(i);
    }

    // Exception in thread "main" java.lang.StackOverflowError
    private static void a() throws InterruptedException {
        System.out.println("a 方法递归recursion");
        Thread.sleep(500);
        a();
    }


}
