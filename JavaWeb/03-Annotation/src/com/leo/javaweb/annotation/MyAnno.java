package com.leo.javaweb.annotation;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */

/**
 * 自定义注解
 * 属性：接口中的抽象方法
 *      返回类型： 基本数据类型、String、枚举、注解类型、以上类型数组
 *
 * 元注解：用于描述注解的注解
 *
 */

public @interface MyAnno {

    int age();

    String name();

    String email() default "";


}
