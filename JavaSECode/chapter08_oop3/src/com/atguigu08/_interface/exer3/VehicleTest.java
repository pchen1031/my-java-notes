package com.atguigu08._interface.exer3;

/**
 * ClassName: VehicleTest
 * Package: com.atguigu08._interface.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/23 22:28
 * @Version 1.0
 */
public class VehicleTest {
    public static void main(String[] args) {
        Developer developer = new Developer();
        Vehicle [] vehicles = new Vehicle[3];
        vehicles[0] = new Bicycle("捷安特","白色");
        vehicles[1] = new ElectricVehicle("雅迪","黑色");
        vehicles[2] = new Car("奔驰","黑色");
        for (int i = 0; i < vehicles.length; i++) {
            developer.takingVehicle(vehicles[i]);
        }
    }
}
