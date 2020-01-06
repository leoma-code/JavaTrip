package com.leo.javaweb.test;

import com.leo.javaweb.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Leo on 2019/12/23.
 * Description :
 */
public class CalculatorTest {

    @Before
    public void init() {
        System.out.println("init");
    }


    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int add = calculator.add(-1, 1);
//        System.out.println(add);

        Assert.assertEquals(2, add);
    }


    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        int add = calculator.sub(10, 1);
        System.out.println(add);
    }


    @After
    public void close() {
        System.out.println("close");
    }
}
