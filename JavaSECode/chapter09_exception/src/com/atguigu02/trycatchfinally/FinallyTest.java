package com.atguigu02.trycatchfinally;

import org.junit.Test;

/**
 * @author 尚硅谷-宋红康
 * @create 14:32
 */
public class FinallyTest {
    @Test
    public void test1(){
        try{
            //try中声明的结构出了try就不能调用了
            String str = "123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println("测试一下");
            System.out.println(i);
        }catch (NumberFormatException e){
            e.printStackTrace();
//            System.out.println(e.getMessage());
//            System.out.println(10 / 0);
        }
//          System.out.println("程序结束");  finally块必须紧跟在try或catch块之后，中间不能插入其他代码
        finally{
            System.out.println("finally test");
        }
    }

    @Test
    public void test2(){
        try{
            //try中声明的结构出了try就不能调用了
            String str = "123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        }catch (NumberFormatException e){
            e.printStackTrace();
//            System.out.println(e.getMessage());
//            try {
//                System.out.println(10 / 0);
//            }catch (RuntimeException r){
//                r.printStackTrace();
//            }
            System.out.println(10 / 0);
        }
        finally {
            System.out.println("程序结束");
            System.out.println(10 / 0);
        }
    }
    @Test
    public void test3(){
        try {
            System.out.println("小小的测试");
        }finally {
            try {
                String str = "123";
                str = "abc";
                int i = Integer.parseInt(str);
                System.out.println("测试一下");
                System.out.println(i);
            }finally {
                System.out.println("大测试");
            }
        }
    }
    @Test
    public void test4(){
        String str = "123";
        str = "abc";
        System.out.println("xixihaha");
        int i = Integer.parseInt(str);
        System.out.println("测试一下");
    }
    @Test
    public void test5(){
        try {
            System.out.println("try中的输出语句");
        }finally {
            System.out.println("finally中的输出语句");
        }
    }





}
