package com.cseu.common.annotation;

import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xueylf
 * @title: LogAnnotation
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/513:55
 * version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(2)
public @interface Log {
    String value() default "";
    String desc() default "";
    int type() default 0;
}
