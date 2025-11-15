package com.atguigu03.threadsafe.runnablesafe;

/**
 * ClassName: WindowTest1
 * Package: com.atguigu03.threadsafe.runnablesafe
 * Description:
 * 使用同步方法解决实现Runnable接口的线程安全问题
 * @Author 彭晨
 * @Create 2025/4/19 17:14
 * @Version 1.0
 */
public class WindowTest1 {
    public static void main(String[] args) {
        SaleTicket1 saleTicket1 = new SaleTicket1();
        Thread t1 = new Thread(saleTicket1,"窗口1");
        Thread t2 = new Thread(saleTicket1,"窗口2");
        Thread t3 = new Thread(saleTicket1,"窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
class SaleTicket1 implements Runnable{
    int ticket = 100;
    boolean isFlag = true;
    @Override
    public void run() {
        while (isFlag){
            show();
        }
    }
    public synchronized void show(){
        if (ticket > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(Thread.currentThread().getName() + "票号:" + ticket);
            ticket--;
        }else {
            isFlag = false;
        }
    }
}