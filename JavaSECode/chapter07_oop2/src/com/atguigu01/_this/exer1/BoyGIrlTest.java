package com.atguigu01._this.exer1;

/**
 * ClassName: BoyGIrlTest
 * Package: com.atguigu01._this.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/2 20:59
 * @Version 1.0
 */
public class BoyGIrlTest {
    public static void main(String[] args) {
        Boy boy = new Boy("杰克",24);
        Girl girl = new Girl("露丝",20);
        girl.marry(boy);
        boy.shout();
    }
}
