package com.atguigu01.create.exer1;

/**
 * ClassName: PrintNumberTest
 * Package: com.atguigu01.create.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/17 15:29
 * @Version 1.0
 */
public class PrintNumberTest {
    public static void main(String[] args) {
        //方式一
//        EvenNumberTest evenNumberTest = new EvenNumberTest();
//        evenNumberTest.start();
//        OddNumberTest oddNumberTest = new OddNumberTest();
//        oddNumberTest.start();
        //方式2：创建Thread类的匿名子类的匿名对象。
//        new Thread(){
//            public void run() {
//                for (int i = 1; i <= 100; i++) {
//                    if(i % 2 == 0){
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            public void run() {
//                for (int i = 1; i <= 100; i++) {
//                    if(i % 2 != 0){
//                        System.out.println(Thread.currentThread().getName() + ":" + i);
//                    }
//                }
//            }
//        }.start();

        //方式3：使用实现Runnable接口的方式：（提供了Runnable接口匿名实现类的匿名对象
        new Thread(new Runnable(){
            public void run(){
                for (int i = 1; i <= 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                for (int i = 1; i <= 100; i++) {
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }).start();
    }


}
class EvenNumberTest extends Thread{ //打印偶数
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}
class OddNumberTest extends Thread{ //打印奇数
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i%2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

