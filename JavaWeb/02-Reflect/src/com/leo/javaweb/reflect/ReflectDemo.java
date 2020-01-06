package com.leo.javaweb.reflect;

import com.leo.javaweb.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */

/*
    反射： 将类的各个组成部分封装成其他对象，这就称为反射机制
    好处：可以在程序运行中，操作这些对象
         可以解藕，提高程序的可扩展性
         Class Field Constructor Method
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 方法一
        Class cls1 = Class.forName("com.leo.javaweb.domain.Person");
        System.out.println(cls1);

        // 方法二
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);

        // 方法三
        Class<? extends Person> cls3 = new Person().getClass();
        System.out.println(cls3);

        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);

        System.out.println(cls1.getConstructors().length);

        System.out.println("-----------------getFields-------------------");
        // 获取成员变量 所有public修饰的成员变量
        Field[] fields1 = cls1.getFields();
        for (Field f: fields1) {
            System.out.println(f.getName());
        }

        System.out.println("-----------------getFields Set-------------------");
        Field email = cls1.getField("email");

        Person person = new Person();
        email.set(person, "leo@163.com");
        System.out.println(person);

        Field name = cls1.getDeclaredField("name");
        name.setAccessible(true);// 暴力反射 访问私有属性
        name.set(person, "张三");
        System.out.println(person);

        System.out.println("------------------getDeclaredFields------------------");
        // 获取所有成员变量
        Field[] fields = cls1.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        System.out.println("------------------getConstructors------------------");
        Constructor[] constructors = cls1.getConstructors();
        for (Constructor cons : constructors) {
            System.out.println(cons);
        }

        System.out.println("------------------getMethods------------------");
        Method[] methods = cls1.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("------------------getDeclaredMethods------------------");
        Method[] methods1 = cls1.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }

        System.out.println("------------------getMethod Invoke------------------");
        Person person1 = new Person("张三", 18);
        Method run = cls1.getDeclaredMethod("run");
        run.setAccessible(true); // 暴力反射
        run.invoke(person1);

    }
}
