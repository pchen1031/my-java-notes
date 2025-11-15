package com.atguigu3.common_algorithm.exer2;

/**
 * ClassName: ArrayExer02
 * Package: com.atguigu3.common_algorithm.exer2
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 15:33
 * @Version 1.0
 */
public class ArrayExer02 {
    public static void main(String[] args) {
        int[] score= new int[]{5,4,6,8,9,0,1,2,7,3};
        int max = score[0];
        int min = score[0];
        int count = 0;
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]){
                max = score[i];
            }
            if (min > score[i]){
                min = score[i];
            }
            count += score[i];
        }
        double average = (count - max - min)/score.length;
        System.out.println("该选手的平均分为:" + average);
    }
}
