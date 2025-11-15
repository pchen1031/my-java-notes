package com.atguigu1.one.exer2;

import java.util.Scanner;

/**
 * ClassName: ArrayExer02
 * Package: com.atguigu1.one.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/24 18:02
 * @Version 1.0
 */
public class ArrayExer02 {
    public static void main(String[] args) {
        String [] week={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数值（1-7");
        int number =scan.nextInt();
        if(number<1||number>7){
            System.out.println("你输入的数值有误");
        }else {
            System.out.println(week[number - 1]);
        }
        scan.close();
    }
}
