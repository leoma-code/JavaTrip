package com.leo.javaweb.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */

@Pro(className = "com.leo.javaweb.annotation.Teacher", methodName = "show")
public class MyAnnoTest {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        // 解析注解
        Class<MyAnnoTest> aClass = MyAnnoTest.class;
        Pro anno = aClass.getAnnotation(Pro.class);// 内存中生成一个类实现了该注解接口,重写了className和methodName抽象方法
        String clsName = anno.className();
        String mtdName = anno.methodName();
        System.out.println("className: " + clsName + "\nmethodName: " + mtdName);


        Class<?> cls = Class.forName(clsName);
        Object o = cls.newInstance();
        Method show = cls.getMethod(mtdName);
        show.invoke(o);
    }

}
