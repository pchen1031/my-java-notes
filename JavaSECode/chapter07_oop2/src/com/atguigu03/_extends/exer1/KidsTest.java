package com.atguigu03._extends.exer1;

/**
 * ClassName: KidsTest
 * Package: com.atguigu03._extends.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/4 22:15
 * @Version 1.0
 */
public class KidsTest {
    public static void main(String[] args) {
        Kids someKid =new Kids();

        someKid.setSex(1);
        someKid.manOrWoman();
        someKid.setSalary(15000);
        someKid.employeed();
        someKid.pringAge();
        ManKind manKind = new ManKind();
        System.out.println(manKind.xixi(manKind));

    }
}
