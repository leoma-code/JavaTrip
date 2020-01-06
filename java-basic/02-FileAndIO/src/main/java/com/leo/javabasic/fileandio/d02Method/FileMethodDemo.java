package com.leo.javabasic.fileandio.d02Method;

import java.io.File;
import java.io.IOException;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class FileMethodDemo {

    public static void main(String[] args) throws InterruptedException, IOException {

        // 构造方法
//        constructorMethods();

        // 获取功能方法
        methodTest1();

    }

    /*
    获取功能方法
     */
    private static void methodTest1() throws InterruptedException, IOException {

        File f1 = new File("/Users/leo/Desktop/a.txt");
        String absolutePath = f1.getAbsolutePath();
        System.out.println("absolutePath : " + absolutePath + "\n path : " + f1.getPath());
        System.out.println("name : " + f1.getName());
        System.out.println("a.txt 大小 ：" + f1.length());

        boolean f1Exist = f1.exists();
        System.out.println("f1 是否存在 ：" + f1Exist);

        boolean directory = f1.isDirectory();
        System.out.println("f1 是不是文件夹 ：" + directory);
        boolean file = f1.isFile();
        System.out.println("f1 是不是文件 : " + file);

        try {
            boolean newFile = f1.createNewFile();
            System.out.println("创建文件是否成功 : " + newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);
        boolean delete = f1.delete();
        System.out.println("f1 是否删除成功 : " + delete);

        System.out.println("----------------------------------------------------------------------");


        File f2 = new File("a.txt");
        System.out.println("absolutePath2 : " + f2.getAbsolutePath() + "\n path : " + f2.getPath());
        System.out.println("name : " + f2.getName());
        System.out.println("a.txt 大小 ：" + f2.length());

        boolean f2Exist = f2.exists();
        System.out.println("f2 是否存在 ：" + f2Exist);

        boolean directory1 = f2.isDirectory();
        System.out.println("f2 是不是文件夹 ：" + directory1);
        boolean file1 = f2.isFile();
        System.out.println("f2 是不是文件 : " + file1);

        System.out.println("----------------------------------------------------------------------");



        File f3 = new File("/Users/leo/Desktop/b.java");
        System.out.println("absolutePath3 : " + f3.getAbsolutePath());
        System.out.println("b.java 大小 ：" + f3.length());

        boolean f3Exist = f3.exists();
        System.out.println("f3 是否存在 ：" + f3Exist);

        boolean directory2 = f3.isDirectory();
        System.out.println("f3 是否是文件夹 ：" + directory2);

        boolean file2 = f3.isFile();
        System.out.println("f3 是否是文件 : " + file2);

        System.out.println("----------------------------------------------------------------------");

        File f4 = new File("/Users/leo/Desktop/test/test1");
        boolean mkdir = f4.mkdir();
        System.out.println("mkdir 创建多级文件夹是否成功 : " + mkdir);
        boolean mkdirs = f4.mkdirs();
        System.out.println("mkdirs 创建多级文件夹是否成功 : " + mkdirs);

        File f5 = new File("/Users/leo/Desktop/test/a.txt");
        boolean newFile = f5.createNewFile();

        File f6 = new File("/Users/leo/Desktop/test");
        File[] list = f6.listFiles();
        for (int i = 0; i < list.length; i++) {
            System.out.println("list : " + list[i]);
        }

        String[] list1 = f6.list();
        for (int i = 0; i < list1.length; i++) {
            System.out.println("list1 : " + list1[i]);
        }
    }


    private static void constructorMethods() {

        File f1 = new File("/Users/leo/Desktop");
        System.out.println(f1);


        System.out.println("----------------------------------------------");

        File f2 = new File("/Users/leo/Desktop", "a.txt");
        System.out.println(f2);

        System.out.println("----------------------------------------------");


        File parent = new File("/Users/leo/Desktop");
        File f3 = new File(parent, "b.java");
        System.out.println(f3);



        
        System.out.println(f3.exists());

        try {
            boolean newFile = f3.createNewFile();
            System.out.println("newFile : " + newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
