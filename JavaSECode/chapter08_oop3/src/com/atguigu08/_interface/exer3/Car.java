package com.atguigu08._interface.exer3;

/**
 * ClassName: Car
 * Package: com.atguigu08._interface.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/23 22:22
 * @Version 1.0
 */
public class Car extends Vehicle implements Power{
    private String carNumber;

    public Car(String brand, String color) {
        super(brand, color);
    }

    public Car(String brand, String color, String carNumber) {
        super(brand, color);
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("汽车内燃机");
    }

    @Override
    public void power() {
        System.out.println("汽车使用汽油提供动力");
    }
}
