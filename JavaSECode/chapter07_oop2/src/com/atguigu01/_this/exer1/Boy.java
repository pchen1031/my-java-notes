package com.atguigu01._this.exer1;

/**
 * ClassName: Boy
 * Package: com.atguigu01._this.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 20:05
 * @Version 1.0
 */
public class Boy {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void marry(Girl girl){
        System.out.println("我想娶" + girl.getName());
    }
    public void shout(){
        if (age > 22){
            System.out.println("我可以结婚了");
        }else{
            System.out.println("我只能谈恋爱");
        }
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Boy() {
    }

}
