package com.atguigu04.example.exer1;

/**
 * ClassName: PersonTest
 * Package: com.atguigu04.example.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/27 15:59
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 =new Person();
        p1.name = "彭晨";
        p1.age = 18;
        p1.gender = '男';

        p1.study();
        int age = p1.showAge();
        System.out.println(age);
        p1.addAge(2);
        int age2 = p1.showAge();
        System.out.println(age2);
    }
}
