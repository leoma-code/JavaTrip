package com.leo.javabasic.fileandio.d05Properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Leo on 2019/12/20.
 * Description :
 */

/*
    Properties继承Hashtable
 */
public class PropertiesDemo {

    public static void main(String[] args) {


//        method1();

//        method2();

        method3();
    }

    private static void method3() {

        Properties properties = new Properties();

        System.out.println(properties);

        FileReader fr = null;
        try {
            fr = new FileReader("properties.txt");
            properties.load(fr);

            System.out.println("使用字符输入流读取properties文件：" + properties);

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


//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream("properties.txt");
//            properties.load(fis);
//
//            System.out.println(properties);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    private static void method2() {
        Properties properties = new Properties();
        properties.setProperty("赵丽颖", "165");
        properties.setProperty("古力娜扎", "168");


        FileWriter fw = null;
        try {
            fw = new FileWriter("properties.txt");
            properties.store(fw, "Properties store Writer");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("properties.txt");
//            properties.store(fos, "Properties store OutputStream");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

    }


    // 使用Properties存储数据
    private static void method1() {

        Properties properties = new Properties();
        properties.setProperty("aaa", "aaaValue");
        properties.setProperty("bbb", "bbbValue");

        System.out.println(properties);
        System.out.println(properties.getProperty("bbb"));

        Set<String> propertyNames =  properties.stringPropertyNames();
        System.out.println(propertyNames);
        for(String key: propertyNames) {
            System.out.println(key);
        }
    }
}
