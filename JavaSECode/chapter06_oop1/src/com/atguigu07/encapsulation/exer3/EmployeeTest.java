package com.atguigu07.encapsulation.exer3;

import java.util.Scanner;

/**
 * ClassName: EmployeeTest
 * Package: com.atguigu07.encapsulation.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/1 16:48
 * @Version 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[2];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
            System.out.println("---------------请输入第" + (i+1) + "位员工的信息------------");
            System.out.println("请输入姓名:");
            employees[i].setName(scanner.next());
            System.out.println("请输入性别:");
            employees[i].setGender(scanner.next().charAt(0));
            System.out.println("请输入年龄:");
            employees[i].setAge(scanner.nextInt());
            System.out.println("请输入电话:");
            employees[i].setPhoneNumber(scanner.next());
        }
        System.out.println("-----------员工列表----------");
        System.out.println("姓名\t性别\t年龄\t电话");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getInfo());
        }
        System.out.println("----------员工列表完成---------");
    }
}
