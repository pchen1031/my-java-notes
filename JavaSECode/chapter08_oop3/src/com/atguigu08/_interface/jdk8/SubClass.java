package com.atguigu08._interface.jdk8;

/**
 * ClassName: SubClass
 * Package: com.atguigu08._interface.jdk8
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/24 10:40
 * @Version 1.0
 */
public class SubClass implements CompareA,CompareB{

    @Override
    public void method3() {
        CompareA.super.method3();
    }
}
