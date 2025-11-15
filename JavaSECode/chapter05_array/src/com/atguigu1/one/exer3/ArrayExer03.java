package com.atguigu1.one.exer3;

import java.util.Scanner;

/**
 * ClassName: ArrayExer03
 * Package: com.atguigu1.one.exer3
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/24 18:14
 * @Version 1.0
 */
public class ArrayExer03 {
    public static void main(String[] args) {
        //还可以优化
        Scanner scan =new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int number = scan.nextInt();
        int [] students = new int[number];
        System.out.println("请输入学生成绩");
        for (int i = 0; i < number; i++) {
            students[i] = scan.nextInt();
        }
        //获取学生成绩最大值
        int max =students[0];
        for (int i = 1; i <number ; i++) {
            if(students[i]>max){
                max = students[i];
            }
        }
        System.out.println("最高分是"+max);
        for (int i = 0; i <number ; i++) {
            if(students[i]>=max-10){
                System.out.println("student " + i +"score is" + students[i] + "gread is A");
            } else if (students[i]>=max-20) {
                System.out.println("student " + i +"score is" + students[i] + "gread is B");
            } else if (students[i]>=max-30) {
                System.out.println("student " + i +"score is" + students[i] + "gread is C");
            }else {
                System.out.println("student " + i +"score is" + students[i] + "gread is D");
            }
        }

    }
}
