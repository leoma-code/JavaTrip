package com.leo.javaweb.annotation;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */

@SuppressWarnings("all") // 压制警告
public class AnnoDemo1 {

    @Override // 检测被该注解标注的方法是否继承至父类
    public String toString() {
        return super.toString();
    }


    @Deprecated // 标记过时
    private void show1() {

    }


}
