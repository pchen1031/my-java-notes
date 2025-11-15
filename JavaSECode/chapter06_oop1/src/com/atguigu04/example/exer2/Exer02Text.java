package com.atguigu04.example.exer2;

/**
 * ClassName: Exer02Text
 * Package: com.atguigu04.example.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/27 16:32
 * @Version 1.0
 */
public class Exer02Text {
    public static void main(String[] args) {
        Exer02 text =new Exer02();
        text.method1();
        int area = text.method2();
        System.out.println(area);
        int area2 = text.method3(10,10);
        System.out.println(area2);
    }
}
