package com.atguigu09.inner;

/**
 * ClassName: OuterClassTest1
 * Package: com.atguigu09.inner
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/25 11:11
 * @Version 1.0
 */
public class OuterClassTest1 {
    public void method1(){
        //局部内部类
        class A{
            //可以声明属性 方法等
        }
    }
    //开发中的场景
    public Comparable getInstance(){
        //方式1 提供了接口实现类的匿名对象
//        class MyComparable implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//
//        return new MyComparable();

        //方式二 提供了接口匿名实现类的对象
//        Comparable c = new Comparable() {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        };
//                return c；
//      方式三 提供了接口匿名实现类的匿名对象
//        return new Comparable() {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        };
        //方式四
        class MyComparable implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        MyComparable myComparable = new MyComparable();
        return myComparable;
    }


//    public static void main(String[] args) {
//        OuterClassTest1 outerClassTest1 = new OuterClassTest1();
//        System.out.println(outerClassTest1.getInstance().compareTo(outerClassTest1));
//    }
}
