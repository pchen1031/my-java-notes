package com.atguigu04.override.exer2;

/**
 * ClassName: Cylinder
 * Package: com.atguigu03._extends.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/4 22:36
 * @Version 1.0
 */
public class Cylinder extends Circle {
    private double length;
    public Cylinder(){
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double findVolume(){
        return Math.PI * findArea() * length;
    }

    @Override
    public double findArea() {
        return Math.PI * getRadius() * getRadius() * 2 +
                2 * Math.PI * getRadius() * getLength();
    }
}
