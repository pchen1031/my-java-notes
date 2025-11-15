package com.atguigu01.string;

import org.junit.Test;

/**
 * ClassName: StringDemo
 * Package: com.atguigu01.string
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/21 15:48
 * @Version 1.0
 */
public class StringDemo {
    @Test
    public void test1(){
        String s = "papapapa";
        String s3 = "hello";
        System.out.println(Integer.toHexString(System.identityHashCode(s)));
        s = "hello";
        System.out.println(Integer.toHexString(System.identityHashCode(s)));
        System.out.println(Integer.toHexString(System.identityHashCode(s3)));
        String s2 = new String("123");
        s2 = "236666";
        s2 = new String("78767866");
        String s4 = new String("12346789797878");
        System.out.println(Integer.toHexString(System.identityHashCode(s4)));
        s4 = "sdsdsdsds";
        s4 = "hello";
        System.out.println(Integer.toHexString(System.identityHashCode(s4)));
        System.out.println(s2);
    }
    
}
