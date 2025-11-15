package com.atguigu08._interface;

/**
 * ClassName: InterfaceTest
 * Package: com.atguigu08._interface
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/22 15:25
 * @Version 1.0
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        System.out.println(Plane.MAX_SPEED);
//        Plane plane =new Plane() {
//            @Override
//            public void fly() {
//                System.out.println("飞机会飞");
//            }
//        };
        Bullet bullet = new Bullet();
        bullet.fly();
        bullet.attack();
        Flyable flyable = new Bullet();
        System.out.println(flyable.MAX_SPEED);
        flyable.fly();
    }
}
interface Flyable{
    public static final int MIN_SPEED = 0;
    int MAX_SPEED = 7900;//可以省略 public static final
    void fly();//可以省略 public abstract
}
interface Attackable{
    void attack();
}
abstract class Plane implements Flyable{

}
class Bullet extends Object implements Flyable,Attackable{//可以继承和implements同时进行
    @Override
    public void fly() {
        System.out.println("让子弹飞一会");
    }

    @Override
    public void attack() {
        System.out.println("子弹有杀伤力");
    }
}
interface AA{
    void method1();
}
interface BB{
    void method2();
}
interface CC extends AA,BB{

}
class DD implements CC{

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}
