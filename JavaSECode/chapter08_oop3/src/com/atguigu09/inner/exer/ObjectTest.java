package com.atguigu09.inner.exer;

/**
 * ClassName: ObjectTest
 * Package: com.atguigu09.inner.exer
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/25 17:43
 * @Version 1.0
 */
public class ObjectTest {
    public static void main(String[] args) {
       new Object(){
            public void test(){
                System.out.println("尚硅谷");
            }
        }.test();
    }
}

