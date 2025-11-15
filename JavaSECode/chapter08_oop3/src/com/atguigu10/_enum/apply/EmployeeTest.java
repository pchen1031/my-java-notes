package com.atguigu10._enum.apply;

/**
 * ClassName: EmployeeTest
 * Package: com.atguigu10._enum.apply
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/28 15:49
 * @Version 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee("彭晨",18,Status.BUSY);
        System.out.println(employee.toString());
    }
}
