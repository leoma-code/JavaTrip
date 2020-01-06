package com.leo.javaweb.annotation;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */


@MyAnno(age = 10, name = "张三", email = "")
public class MyAnnoDemo {

    @MyAnno2(value = 1, name = "张三", email = "xx@163.com")
    public void show() {

    }


}
