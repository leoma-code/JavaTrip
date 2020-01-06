package com.leo.javaweb.annotation;

import java.lang.annotation.*;

/**
 * Created by Leo on 2019/12/24.
 * Description :
 */

@Target(value = {ElementType.METHOD, ElementType.FIELD}) // 描述注解的使用位置
@Retention(RetentionPolicy.RUNTIME) // 描述注解的保留位置
@Documented // 描述注解是否被抽取到API文档中呢
@Inherited  // 描述注解是否被子类继承
public @interface MyAnno2 {

    int value();

    String name();

    String email();



}
