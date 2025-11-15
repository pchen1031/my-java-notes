package com.atguigu08._interface.exer1;

/**
 * ClassName: Eatable
 * Package: com.atguigu08._interface.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/23 16:00
 * @Version 1.0
 */
public interface Eatable {
    void eat();
}
class Chinese implements Eatable{

    @Override
    public void eat() {
        System.out.println("中国人用筷子吃饭");
    }
}
class American implements Eatable{

    @Override
    public void eat() {
        System.out.println("美国人用刀叉吃饭");
    }
}
class Indian implements Eatable{

    @Override
    public void eat() {
        System.out.println("印度人用手抓吃饭");
    }
}
