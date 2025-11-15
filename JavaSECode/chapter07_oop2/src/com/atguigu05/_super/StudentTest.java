package com.atguigu05._super;


/**
 * ClassName: StudentTest
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 11:48
 * @Version 1.0
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.eat();
        s1.sleep();

        s1.show();

        System.out.println();
        s1.show2();

        System.out.println(s1.name);

        //************************
        System.out.println();

        Student s2 = new Student();

        System.out.println("***************");

        Student s3 = new Student("Tom",12);

        Student1 student1 =new Student1();
        System.out.println("**********************");
        Student1 student2 =new Student1("ceshi");
    }
}
