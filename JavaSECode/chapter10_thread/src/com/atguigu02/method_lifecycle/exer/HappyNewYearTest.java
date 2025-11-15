package com.atguigu02.method_lifecycle.exer;

/**
 * ClassName: HappyNewYearTest
 * Package: com.atguigu02.method_lifecycle.exer
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/19 20:17
 * @Version 1.0
 */
public class HappyNewYearTest {
    public static void main(String[] args) {
        HappyNewYear happyNewYear = new HappyNewYear();
        Thread thread = new Thread(happyNewYear);
        thread.start();
    }
}
class HappyNewYear implements Runnable{
    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i > 0){

                System.out.println(i);
            }else {

                System.out.println("新年快乐");
            }
        }
    }
}
