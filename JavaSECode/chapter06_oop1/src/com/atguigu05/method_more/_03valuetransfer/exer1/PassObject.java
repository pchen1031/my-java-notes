package com.atguigu05.method_more._03valuetransfer.exer1;

/**
 * ClassName: PassObject
 * Package: com.atguigu05.method_more._03valuetransfer.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/28 17:34
 * @Version 1.0
 */
public class PassObject {
    public void printAreas(Circle c, int time){
        int i = 1;
        for (; i <=time ; i++) {
            c.radius = i;
            System.out.println("当前半径为:" + i + " Area:" + c.findArea());
        }
        c.radius = i;
    }
}
