package com.atguigu11.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * ClassName: MyAnnotation
 * Package: com.atguigu11.annotation
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/29 18:27
 * @Version 1.0
 */
@Target({TYPE, FIELD, METHOD,CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
