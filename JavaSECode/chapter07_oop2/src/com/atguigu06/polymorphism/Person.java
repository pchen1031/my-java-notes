package com.atguigu06.polymorphism;

/**
 * ClassName: Person
 * Package: com.atguigu06.polymorphism
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/7 16:47
 * @Version 1.0
 */
public class Person {
    String name;
    int age;

    int id = 1001;
    public void niao(){
        System.out.println("男人可以尿尿");
    }

    public void eat(){
        System.out.println("人吃饭");
    }

    public void walk(){
        System.out.println("人走路");
    }
}
