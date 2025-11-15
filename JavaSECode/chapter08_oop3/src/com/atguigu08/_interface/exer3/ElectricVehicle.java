package com.atguigu08._interface.exer3;

/**
 * ClassName: ElectricVehicle
 * Package: com.atguigu08._interface.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/23 22:21
 * @Version 1.0
 */
public class ElectricVehicle extends Vehicle implements Power{
    public ElectricVehicle() {
    }

    public ElectricVehicle(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("电动车通过电机驱动行驶");
    }

    @Override
    public void power() {
        System.out.println("电动车通过电提供动力");
    }
}
