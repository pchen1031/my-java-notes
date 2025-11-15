package com.atguigu07.object.tostring.exer;

/**
 * ClassName: CircleTest
 * Package: com.atguigu07.object.tostring.exer
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/9 23:41
 * @Version 1.0
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle circle1 =new Circle(2.3);
        Circle circle2 =new Circle("red",2.0,3.4);
        System.out.println(circle1.getColor().equals(circle2.getColor()));
    }
}
