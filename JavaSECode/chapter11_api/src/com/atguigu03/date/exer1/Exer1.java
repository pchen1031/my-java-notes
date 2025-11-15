package com.atguigu03.date.exer1;

import java.util.Date;

/**
 * ClassName: Exer1
 * Package: com.atguigu03.date.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/23 20:14
 * @Version 1.0
 */
public class Exer1 {
    public static void main(String[] args) {
        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String str = simpleDateFormat.format(date);
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }
}
