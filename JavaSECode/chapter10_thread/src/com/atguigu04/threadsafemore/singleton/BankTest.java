package com.atguigu04.threadsafemore.singleton;

/**
 * ClassName: BankTest
 * Package: com.atguigu04.threadsafemore.singleton
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/20 9:51
 * @Version 1.0
 */
public class BankTest {
    static Bank bank1 = null;
    static Bank bank2 = null;
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                bank1 = Bank.getInstance();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                bank2 = Bank.getInstance();
            }
        };
        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bank1);
        System.out.println(bank2);
        System.out.println(bank1 == bank2);
    }
}
class Bank{
    private Bank(){

    }
    private static volatile Bank instance = null;  //volatile避免指令重排

    //方式一
//    public synchronized static Bank getInstance() {
//        if (instance == null){
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            instance = new Bank();
//        }
//        return instance;
//    }
    //方式二同步代码块
//    public  static Bank getInstance() {
//        synchronized (Bank.class) {
//            if (instance == null){
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }
    //方式三 基于方式二 效率更高一些
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}