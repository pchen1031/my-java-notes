package com.atguigu12.wrapper;

import org.junit.Test;

/**
 * ClassName: WrapperTest1
 * Package: com.atguigu12.wrapper
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/31 17:42
 * @Version 1.0
 */
public class WrapperTest1 {
    /*
    基本数据类型、包装类 ---> String类型：① 调用String的重载的静态方法valueOf(xxx xx) ; ② 基本数据类型的变量 + ""

    String类型 ---> 基本数据类型、包装类: 调用包装类的静态方法：parseXxx()
     */

    @Test
    public void test2(){
        //String类型 ---> 基本数据类型、包装类
        //调用包装类的静态方法：parseXxx()
        String s1 ="18";
        int i = Integer.parseInt(s1);
        System.out.println(i + 10);
        String s2 = "13.4";
        double j =  Double.parseDouble(s2);
        System.out.println(j);
        String s3 = "TruE123";
        boolean b1 = Boolean.parseBoolean(s3);
        System.out.println(b1);
    }

    @Test
    public void test1(){
        // 基本数据类型、包装类 ---> String类型：
        //方式一 调用String的重载的静态方法valueOf(xxx xx);
        int i1 = 18;
        String str1 = String.valueOf(i1);
        System.out.println(str1);

        boolean b1 = true;
        Boolean b2 = b1;
        String str2 = String.valueOf(b1);
        String str3 = String.valueOf(b2);
        //方式二 基本数据类型的变量 + ""
        String str4 = i1 + "";
        String str5 = b1 + "";
    }

}
