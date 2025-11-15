package com.atguigu07.encapsulation.exer1;

/**
 * ClassName: Person
 * Package: com.atguigu07.encapsulation.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/1 16:04
 * @Version 1.0
 */
public class Person {
    private int age;

    public void setAge(int m){
        if(m >= 0&& m <= 130){
            age = m;
        }else{
            System.out.println("输入的年龄有误");
        }
    }
    public int getAge(){
        return age;
    }
}
