package com.atguigu01.create.runnable;

/**
 * ClassName: EvenNumberTest
 * Package: com.atguigu01.create.runnable
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/17 16:36
 * @Version 1.0
 */
public class EvenNumberTest {
    public static void main(String[] args) {
        EvenPrint evenPrint = new EvenPrint();
        new Thread(evenPrint).start();
    }
}
class EvenPrint implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
