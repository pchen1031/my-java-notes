package com.atguigu02.memory;

/**
 * Perosn类对应的测试类
 *
 * @author 尚硅谷-宋红康
 * @create 14:38
 */
public class PersonTest {
    public static void main(String[] args) {
        Person ren = new Person();
        ren.name = "彭晨";
        ren.gender = '男';
        ren.age = 18;
        ren.eat();
        ren.sleep(8);
        ren.interesting("唱跳Rap篮球");
    }
}
