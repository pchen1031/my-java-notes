package com.atguigu03.date.exer2;

import java.util.Calendar;

/**
 * ClassName: Exer2
 * Package: com.atguigu03.date.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/23 21:45
 * @Version 1.0
 */
public class Exer2 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.set(2001,9,31);
        System.out.println(calendar.getTime());
    }
}
