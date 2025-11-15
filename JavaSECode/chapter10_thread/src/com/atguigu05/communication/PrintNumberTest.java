package com.atguigu05.communication;

/**
 * ClassName: PrintNumberTest
 * Package: com.atguigu05.communication
 * Description:使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * @Author 彭晨
 * @Create 2025/4/20 18:40
 * @Version 1.0
 */
public class PrintNumberTest {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Thread t1 = new Thread(printNumber,"线程1");
        Thread t2 = new Thread(printNumber,"线程2");
        t1.start();
        t2.start();

    }
}
class PrintNumber implements Runnable{
    private static int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if (number <= 100){
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        wait();//线程一旦执行到此处，就进入阻塞状态，并且会释放对同步监视器的调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
