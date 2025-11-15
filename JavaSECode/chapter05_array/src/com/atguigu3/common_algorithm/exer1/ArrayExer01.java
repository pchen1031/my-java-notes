package com.atguigu3.common_algorithm.exer1;

/**
 * ClassName: ArrayExer01
 * Package: com.atguigu3.common_algorithm.exer1
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/2/25 14:55
 * @Version 1.0
 */
public class ArrayExer01 {
    public static void main(String[] args) {
        int[] arr =new int[10];
        for (int i = 0; i <10 ; i++) {
            arr[i] = (int)(Math.random() * (99 - 10 + 1)) + 10;
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        int max =arr[0];
        int min =arr[0];
        int count =0;
        for (int i = 1; i < 10; i++) {
            if (max<arr[i]){
                max = arr[i];
            }
            if (min>arr[i]){
                min = arr[i];
            }
            count += arr[i];
        }
        double average = count/10;
        System.out.println("最大值为:" + max);
        System.out.println("最小值为:" + min);
        System.out.println("总和为:" + count);
        System.out.println("平均值为:" + average);
    }


}
