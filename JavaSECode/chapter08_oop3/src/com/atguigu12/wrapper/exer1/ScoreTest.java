package com.atguigu12.wrapper.exer1;

import java.util.Scanner;
import java.util.Vector;

/**
 * ClassName: ScoreTest
 * Package: com.atguigu12.wrapper.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/3/31 21:32
 * @Version 1.0
 */
public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1.创建Vector对象：Vector v=new Vector();  v是一个存放成绩的容器（类似于创建数组）
        Vector v=new Vector();
        int maxScore = 0;
        //2.从键盘获取多个学生成绩，放到容器v中 负数代表结束
        while (true){
            System.out.println("请输入学生成绩（输入负数代表结束）");
            int intScore = scanner.nextInt();
            if(intScore < 0){
                break;
            }
//            Integer score = Integer.valueOf(intScore);
//            v.addElement(score);
            v.addElement(intScore);//自动装箱 存的是一个对象
            //3.获取学生成绩的最大值
            if(maxScore < intScore){
                maxScore = intScore;
            }

        }
        System.out.println("最高分：" + maxScore);
        //4. 依次获取v中的每个学生成绩，与最高分进行比较，获取学生等级，并输出
        for(int i = 0;i < v.size();i++){
            Object objScore = v.elementAt(i);//
            //方式1：
//            Integer integerScore = (Integer) objScore;
//            //拆箱
//            int score = integerScore.intValue();

            //方式2：自动拆箱
            int score = (Integer) objScore;
            char grade;
            if(maxScore - score <= 10){
                grade = 'A';
            }else if(maxScore - score <= 20){
                grade = 'B';
            }else if(maxScore - score <= 30){
                grade = 'C';
            }else{
                grade = 'D';
            }

            System.out.println("student " + i +" score is " + score + " grade is " + grade);

        }

        scanner.close();
    }
}
