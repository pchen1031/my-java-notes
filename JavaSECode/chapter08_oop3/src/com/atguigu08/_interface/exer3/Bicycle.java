package com.atguigu08._interface.exer3;

/**
 * ClassName: Bicycle
 * Package: com.atguigu08._interface.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/23 22:20
 * @Version 1.0
 */
public class Bicycle extends Vehicle {
    public Bicycle() {
    }

    public Bicycle(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("自动车脚蹬");
    }

}
