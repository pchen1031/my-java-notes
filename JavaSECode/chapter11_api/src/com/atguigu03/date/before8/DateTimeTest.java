package com.atguigu03.date.before8;

import org.junit.Test;

import java.util.Date;

/**
 * ClassName: DateTimeTest
 * Package: com.atguigu03.date.before8
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/23 17:27
 * @Version 1.0
 */
public class DateTimeTest {
    @Test
    public void test1(){
        Date date1 = new Date();
        System.out.println(date1);
        long time = date1.getTime();//对应的毫秒数

        Date date2 = new Date(45654565);
        System.out.println(date2);//打印的是距离1970.1.1 传入构造器的这些毫秒数的日子
    }
    @Test
    public void test2(){
        java.sql.Date date = new java.sql.Date(4554555);
        System.out.println(date);
    }


}
