package com.atguigu08._interface.jdk8;

/**
 * ClassName: CompareA
 * Package: com.atguigu08._interface.jdk8
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/24 10:39
 * @Version 1.0
 */
public interface CompareA {
    public static void method1(){
        System.out.println("compareA:北京");
    }
    public default void method2(){
        System.out.println("compareA:上海");
    }
    public default void method3(){
        System.out.println("compareA:广州");
    }
}
