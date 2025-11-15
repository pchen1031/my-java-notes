package com.atguigu05.method_more._03valuetransfer;

/**
 * ClassName: ValueTransferTest01
 * Package: com.atguigu05.method_more
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/28 16:39
 * @Version 1.0
 */
public class ValueTransferTest01 {
    public static void main(String[] args) {
        int m = 10;
        ValueTransferTest01 test = new ValueTransferTest01();
        System.out.println(test.method1(m));
        System.out.println(m);
        Person c =new Person();
        c.age = 18;
        test.method2(c);
        System.out.println(c.age);
        System.out.println(c);
        int[] xixi = new int[]{1,2,3};
        int[] haha = new int[3];
        haha = xixi;
        System.out.println(xixi);
        System.out.println(haha);
        for (int i = 0; i < haha.length; i++) {
            System.out.println(haha[i]);
        }
    }
    public int method1(int m){
        return m+1;
    }
    public void method2(Person p){
        p.age++;
        System.out.println(p);
    }
}
class Person{
    int age;
}
