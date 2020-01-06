package com.leo.javaweb.annodemo;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */
public class CheckTest {


    @Test
    public void testCalculator() throws IOException {

        Calculator c = new Calculator();

        Class<? extends Calculator> cls = c.getClass();

        Method[] methods = cls.getDeclaredMethods();

        int num = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method mtd: methods) {

            if (mtd.isAnnotationPresent(Check.class)) {
                try {
                    mtd.invoke(c);
                } catch (Exception e) {
                    num ++;
                    bw.write("异常方法：" + mtd.getName());
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试共出现了" + num + "个异常");
        bw.flush();
        bw.close();
    }
}
