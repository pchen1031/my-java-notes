package com.atguigu03.list.exer1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: PersonTest
 * Package: com.atguigu03.list.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/29 15:10
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();
        while (true){
            System.out.print("输入1录入学生信息,输入0结束录入");
            int isFlag = scanner.nextInt();
            if (isFlag == 0){
                break;
            }
            System.out.print("请输入学生姓名:");
            String name = scanner.next();
            System.out.print("请输入学生年龄:");
            int age = scanner.nextInt();
            arrayList.add(new Person(name,age));
        }
        for (Object obj : arrayList){
            System.out.println(obj);
        }
//        System.out.println(arrayList);
        scanner.close();
    }
}
