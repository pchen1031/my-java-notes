package com.atguigu03.threadsafe.runnablesafe;

/**
 * ClassName: WindowTest
 * Package: com.atguigu03.threadsafe.notsafe
 * Description:
 *  使用同步代码块解决线程安全问题
 * @Author 彭晨
 * @Create 2025/4/18 19:58
 * @Version 1.0
 */
public class WindowTest {
    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        Thread t1 = new Thread(saleTicket,"窗口1");
        Thread t2 = new Thread(saleTicket,"窗口2");
        Thread t3 = new Thread(saleTicket,"窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket implements Runnable{
    int ticket = 100;
    Object object = new Object();
    @Override
    public void run() {
        while (true){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){//object必须是唯一的 因为只造了SaleTicket一个实例，所以object是唯一的。


            if (ticket > 0){
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "票号:" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
    }
}
