package com.atguigu05.method_more._03valuetransfer.exer1;

/**
 * ClassName: Test
 * Package: com.atguigu05.method_more._03valuetransfer.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/28 17:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        PassObject passObject = new PassObject();
        passObject.printAreas(circle,5);
        System.out.println("当前半径值为:" + circle.radius);
    }
}
