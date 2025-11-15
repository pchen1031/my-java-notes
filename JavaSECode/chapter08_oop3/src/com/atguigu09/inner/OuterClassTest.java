package com.atguigu09.inner;

/**
 * ClassName: OuterClassTest
 * Package: com.atguigu09.inner
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/24 20:38
 * @Version 1.0
 */
public class OuterClassTest {
    public static void main(String[] args) {
        //创建静态内部类
        Person.Dog dog = new Person.Dog();
        dog.eat();
        //创建非静态内部类
//        Person.Bird bird = new Person.Bird(); 报错 因为没有对象
        Person p1 = new Person();
        Person.Bird bird = p1.new Bird();
        bird.eat();
        bird.show("黄鹂鸟");
    }
}
class Person{
    int age = 18;
    String name = "Tom";
    //静态成员内部类
    static class Dog{
        public void eat(){
            System.out.println("狗吃骨头");
        }
    }
    //非静态成员内部类
    class Bird{
        String name = "啄木鸟";
        public void eat(){
            System.out.println("鸟吃虫子");
        }
        public void show(String name){
            System.out.println("age:" + age);//省略了Person.this
            System.out.println("name:" + name);
            System.out.println("name:" + this.name);
            System.out.println("name:" + Person.this.name);
        }
        public void show1(){
            eat();//相当于this.eat();
            Person.this.eat();
        }
    }
    public void eat(){
        System.out.println("人吃饭");
    }
    public void method(){
        //局部内部类
        class InnerClass1{

        }
    }
    public Person(){
        //局部内部类
        class InnerClass1{

        }
    }
    {//局部内部类
        class InnerClass1{

        }
    }
}
