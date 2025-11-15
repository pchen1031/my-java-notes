package com.atguigu02.memory;

/**
 * @author 尚硅谷-宋红康
 * @create 14:31
 */

public class Person {
    String name;
    char gender;
    int age;

    public void eat(){
        System.out.println("人吃饭");
    }
    public void sleep(int hour){
        System.out.println("人至少保证每天" + hour + "小时的睡眠");
    }
    public void interesting(String hoppy){
        System.out.println("我的爱好是" + hoppy);
    }
}
