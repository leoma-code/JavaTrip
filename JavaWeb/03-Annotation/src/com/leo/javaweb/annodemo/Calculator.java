package com.leo.javaweb.annodemo;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */
public class Calculator {

    @Check
    public void add() {
        System.out.println("1 + 0 = " + (1 + 0));
    }

    @Check
    public void sub() {
        System.out.println("1 - 0 = " + (1 - 0));
        String str = null;
        str.toString();
    }

    @Check
    public void mul() {
        System.out.println("1 * 0 = " + (1 * 0));
    }

    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }

    public void show() {
        System.out.println("show.....");
    }
}
