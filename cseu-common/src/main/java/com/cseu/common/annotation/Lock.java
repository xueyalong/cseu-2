package com.cseu.common.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xueylf
 * @title: Lock
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/514:05
 * version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(1)
public @interface Lock {
    int locktime() default 1000;
    String model() default "";
    String key() default "";
}
