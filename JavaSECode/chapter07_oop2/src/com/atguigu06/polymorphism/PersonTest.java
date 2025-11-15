package com.atguigu06.polymorphism;

/**
 * ClassName: PersonTest
 * Package: com.atguigu06.polymorphism
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/7 16:49
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
//        Man man = new Man();
//        System.out.println(man.id);
        Person person = new Man();
        person.niao();
    }
}

