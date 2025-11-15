package com.atguigu08._interface.jdk8;

/**
 * ClassName: SubClassTest
 * Package: com.atguigu08._interface.jdk8
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/24 10:41
 * @Version 1.0
 */
public class SubClassTest {
    public static void main(String[] args) {
        CompareA.method1();
        SubClass subClass = new SubClass();
//        subClass.method1();
        subClass.method2();
    }
}
