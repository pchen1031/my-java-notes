package com.atguigu01.create.thread;

/**
 * ClassName: EvenNumberTest
 * Package: com.atguigu01.create.thread
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/17 14:40
 * @Version 1.0
 */
//        ① 创建一个继承于Thread类的子类
//        ② 重写Thread类的run() --->将此线程要执行的操作，声明在此方法体中
//        ③ 创建当前Thread的子类的对象
//        ④ 通过对象调用start(): 1.启动线程 2.调用当前线程的run()
public class EvenNumberTest {
    public static void main(String[] args) {
        PrintNumber t1 = new PrintNumber();
        t1.start();
        /*
         * 问题1：能否使用t1.run()替换t1.start()的调用，实现分线程的创建和调用? 不能！
         * */
//        t1.run();

        /*
         * 问题2：再提供一个分线程，用于100以内偶数的遍历。
         *
         * 注意：不能让已经start()的线程，再次执行start(),否则报异常IllegalThreadStateException
         * */
//        t1.start();
//        t1.run();
        PrintNumber t2 = new PrintNumber();
        t2.start();

        for (int i = 1; i <= 10000; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ";" + i + "***********");
            }
        }
    }
}
class PrintNumber extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
    public void method(){
        System.out.println("这是一个方法");
    }
}
