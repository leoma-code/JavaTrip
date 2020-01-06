package com.leo.javabasic.fileandio.d08SerializeIO;

import java.io.*;

/**
 * Created by Leo on 2019/12/20.
 * Description :
 */

/// 对象序列化流
public class SerializeIODemo {

    public static void main(String[] args) {

        Person person = new Person("张三", 18);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            oos.writeObject(person);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // ObjectInputStream读取
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Object object = ois.readObject();

            System.out.println(object.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }


    static class Person implements Serializable {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
