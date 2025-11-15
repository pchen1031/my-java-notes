package com.atguigu02.method_lifecycle;

/**
 * ClassName: EvenNumberTest
 * Package: com.atguigu02.method_lifecycle
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/17 22:10
 * @Version 1.0
 */
public class EvenNumberTest {
    public static void main(String[] args) {
        PrintNumber t1 = new PrintNumber("彭晨");
        t1.setName("子线程");
        Thread.currentThread().setName("主线程");
        t1.start();
//        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i + "***********");
            }
            if (i == 20){
                try {
                    t1.join();//join(): 在线程a中通过线程b调用join()，意味着线程a进入阻塞状态，直到线程b执行结束，线程a才结束阻塞状态，继续执行。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        long endTime = System.currentTimeMillis();
//        long elapsedTime = endTime - startTime;
//        System.out.println("执行耗时（毫秒）: " + elapsedTime);
    }
}
class PrintNumber extends Thread{
    public PrintNumber(){

    }
    public PrintNumber(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
        }
    }
}
