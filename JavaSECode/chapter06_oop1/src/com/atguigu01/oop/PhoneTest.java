package com.atguigu01.oop;

/**
 * @author 尚硅谷-宋红康
 * @create 16:29
 */
public class PhoneTest {//phone的测试类
    public static void main(String[] args) {
        Phone p1 = new Phone();//创建Phone类的对象

        //通过Phone的对象调用内部声明的属性和方法
        //格式 "对象.属性" 或 "对象.方法"
        p1.name = "诺基亚";
        p1.price = 1000;
        System.out.println("手机名称为:" + p1.name + " 价格为:" + p1.price);
//        double xixi = 10000000;
//        System.out.println(xixi);
//        System.out.println(10000000);
//        System.out.println(10000000.0);

        //调用方法
        p1.call();
        p1.sendMessage("有内鬼终止交易");
        p1.playGame();
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = arr1;
        int[] arr3 = new int[3];
//        arr3 = arr1;
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "hello";
        System.out.println(s3==s1);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }
}
