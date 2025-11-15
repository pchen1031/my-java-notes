package com.atguigu03._extends.exer2;

/**
 * ClassName: Circle
 * Package: com.atguigu03._extends.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/4 22:30
 * @Version 1.0
 */
public class Circle {
    private double radius;

    public  Circle(){
        radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
