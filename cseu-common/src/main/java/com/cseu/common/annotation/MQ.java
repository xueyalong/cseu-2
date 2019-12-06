package com.cseu.common.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xueylf
 * @title: MQ
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/610:50
 * version 1.0
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(3)
public @interface MQ {
    String exchange() default "";
    String queue() default "";
    String message() default "";
    String desc() default "";
    String delaiy() default "";
}
