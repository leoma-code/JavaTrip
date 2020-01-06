package com.leo.javaweb.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */
public class ReflectFramework {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Properties properties = new Properties();

        ClassLoader classLoader = ReflectFramework.class.getClassLoader();
        InputStream proIS = classLoader.getResourceAsStream("pro.properties");
        properties.load(proIS);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
//        System.out.println(className);
//        System.out.println(methodName);

        Class<?> cls = Class.forName(className);
        Method method = cls.getDeclaredMethod(methodName);
        method.setAccessible(true);
        Object o = cls.newInstance();
        method.invoke(o);
    }


}
